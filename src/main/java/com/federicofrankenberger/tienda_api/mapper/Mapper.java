package com.federicofrankenberger.tienda_api.mapper;

import com.federicofrankenberger.tienda_api.dto.*;
import com.federicofrankenberger.tienda_api.model.*;

import java.util.stream.Collectors;

public class Mapper {

    //Mapeo de Categoria a CategoriaDTO
    public static CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) return null;

        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build();
    }

    //Mapeo de Cliente a ClienteDTO
    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;

        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .direccion(cliente.getDireccion())
                .build();
    }

    //Mapeo de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto producto) {
        if (producto == null) return null;

        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .marca(producto.getMarca())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .idCategoria(producto.getCategoria() != null
                        ? producto.getCategoria().getId()
                        : null)
                .nombreCategoria(producto.getCategoria() != null
                        ? producto.getCategoria().getNombre()
                        : null)
                .build();
    }

    //Mapeo de Sucursal a SucursalDTO
    public static SucursalDTO toDTO(Sucursal sucursal) {
        if (sucursal == null) return null;

        return SucursalDTO.builder()
                .id(sucursal.getId())
                .nombre(sucursal.getNombre())
                .direccion(sucursal.getDireccion())
                .build();
    }

    //Mapeo de DetalleVenta a DetalleVentaDTO
    public static DetalleVentaDTO toDTO(DetalleVenta detalle) {
        if (detalle == null) return null;

        return DetalleVentaDTO.builder()
                .id(detalle.getId())
                .idProducto(detalle.getProducto() != null ? detalle.getProducto().getId() : null)
                .nombreProd(detalle.getProducto() != null ? detalle.getProducto().getNombre() : null)
                .precioProd(detalle.getProducto() != null ? detalle.getProducto().getPrecio() : null)
                .cantProd(detalle.getCantidad())
                .subtotal(detalle.getSubtotal())
                .build();
    }

    //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFechaVenta())
                .estado(venta.getEstado() != null ? venta.getEstado() : null)

                // Datos del cliente
                .idCliente(venta.getCliente() != null ? venta.getCliente().getId() : null)
                .nombreCliente(venta.getCliente() != null ? venta.getCliente().getNombre() : null)
                .apellidoCliente(venta.getCliente() != null ? venta.getCliente().getApellido() : null)

                // Datos de la sucursal
                .idSucursal(venta.getSucursal() != null ? venta.getSucursal().getId() : null)

                // Lista de detalles de venta
                .detalles(
                        venta.getListaItems() != null
                                ? venta.getListaItems().stream()
                                .map(Mapper::toDTO)
                                .collect(Collectors.toList())
                                : null
                )

                // Total de la venta
                .total(venta.getTotal())
                .build();
    }

}
