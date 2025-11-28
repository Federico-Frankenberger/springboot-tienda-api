package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.DetalleVentaDTO;
import com.federicofrankenberger.tienda_api.dto.VentaDTO;
import com.federicofrankenberger.tienda_api.exception.BusinessException;
import com.federicofrankenberger.tienda_api.exception.NotFoundException;
import com.federicofrankenberger.tienda_api.mapper.Mapper;
import com.federicofrankenberger.tienda_api.model.*;
import com.federicofrankenberger.tienda_api.repository.ClienteRepository;
import com.federicofrankenberger.tienda_api.repository.ProductoRepository;
import com.federicofrankenberger.tienda_api.repository.SucursalRepository;
import com.federicofrankenberger.tienda_api.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private SucursalRepository sucursalRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Transactional
    public VentaDTO save(VentaDTO dto) {

        if (dto.getDetalles() == null || dto.getDetalles().isEmpty()) {
            throw new BusinessException("La venta debe contener al menos un producto");
        }

        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));

        Sucursal sucursal = null;
        if (dto.getIdSucursal() != null) {
            sucursal = sucursalRepo.findById(dto.getIdSucursal())
                    .orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));
        }

        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        venta.setEstado(EstadoVenta.PENDIENTE);
        venta.setCliente(cliente);
        venta.setSucursal(sucursal);

        BigDecimal total = BigDecimal.ZERO;

        for (DetalleVentaDTO itemDTO : dto.getDetalles()) {

            if (itemDTO.getCantProd() == null || itemDTO.getCantProd() <= 0) {
                throw new BusinessException(
                        "La cantidad del producto debe ser mayor a 0 (producto ID: " + itemDTO.getIdProducto() + ")"
                );
            }

            Producto producto = productoRepo.findById(itemDTO.getIdProducto())
                    .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

            if (producto.getStock() < itemDTO.getCantProd()) {
                throw new BusinessException("Stock insuficiente para producto " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - itemDTO.getCantProd());
            productoRepo.save(producto);

            DetalleVenta det = new DetalleVenta();
            det.setCantidad(itemDTO.getCantProd());
            det.setProducto(producto);
            det.setPrecioUnitario(producto.getPrecio());

            det.setVenta(venta);

            venta.getListaItems().add(det);

            total = total.add(det.getSubtotal());
        }

        venta.setTotal(total);

        return Mapper.toDTO(ventaRepo.save(venta));
    }

    @Transactional(readOnly = true)
    public VentaDTO findById(Long id) {
        Venta venta = ventaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Venta no encontrada"));

        return Mapper.toDTO(venta);
    }

    @Transactional(readOnly = true)
    public List<VentaDTO> findAll() {
        return ventaRepo.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Transactional
    public VentaDTO cambiarEstado(Long idVenta, EstadoVenta nuevoEstado) {

        Venta venta = ventaRepo.findById(idVenta)
                .orElseThrow(() -> new NotFoundException("Venta no encontrada"));

        if (venta.getEstado() == EstadoVenta.CANCELADA) {
            throw new BusinessException("No es posible cambiar el estado de una venta cancelada");
        }

        if (venta.getEstado() == EstadoVenta.ABONADA) {
            throw new BusinessException("No es posible cambiar el estado de una venta abonada");
        }

        if (venta.getEstado() == nuevoEstado) {
            throw new BusinessException("La venta ya se encuentra en ese estado");
        }

        if (nuevoEstado == EstadoVenta.CANCELADA) {
            venta.getListaItems().forEach(det -> {
                Producto producto = det.getProducto();
                producto.setStock(producto.getStock() + det.getCantidad());
                productoRepo.save(producto);
            });
        }

        venta.setEstado(nuevoEstado);
        return Mapper.toDTO(ventaRepo.save(venta));
    }
}