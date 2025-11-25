package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.ProductoDTO;
import com.federicofrankenberger.tienda_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository repo;

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        return null;
    }

    @Override
    public ProductoDTO update(Long aLong, ProductoDTO dto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<ProductoDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ProductoDTO> findAll() {
        return List.of();
    }
}
