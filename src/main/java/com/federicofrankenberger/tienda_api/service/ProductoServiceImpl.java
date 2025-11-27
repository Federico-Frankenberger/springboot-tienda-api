package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.ProductoDTO;
import com.federicofrankenberger.tienda_api.exception.NotFoundException;
import com.federicofrankenberger.tienda_api.mapper.Mapper;
import com.federicofrankenberger.tienda_api.model.Categoria;
import com.federicofrankenberger.tienda_api.model.Producto;
import com.federicofrankenberger.tienda_api.repository.CategoriaRepository;
import com.federicofrankenberger.tienda_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    @Autowired
    private CategoriaRepository catRep;

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Categoria categoria = catRep.findById(dto.getIdCategoria())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        Producto prod = Producto.builder()
                .nombre(dto.getNombre())
                .marca(dto.getMarca())
                .categoria(categoria)
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
        Producto prod = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        Categoria categoria = catRep.findById(dto.getIdCategoria())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        prod.setNombre(dto.getNombre());
        prod.setMarca(dto.getMarca());
        prod.setPrecio(dto.getPrecio());
        prod.setStock(dto.getStock());
        prod.setCategoria(categoria);
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public void delete(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Producto no encontrado");
        }
        repo.deleteById(id);
    }

    @Override
    public ProductoDTO findById(Long id) {
        Producto prod = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        return Mapper.toDTO(prod);
    }

    @Override
    public List<ProductoDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }
}
