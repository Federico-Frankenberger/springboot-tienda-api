package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.CategoriaDTO;
import com.federicofrankenberger.tienda_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    @Override
    public CategoriaDTO save(CategoriaDTO dto) {
        return null;
    }

    @Override
    public CategoriaDTO update(Long aLong, CategoriaDTO dto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<CategoriaDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<CategoriaDTO> findAll() {
        return List.of();
    }
}
