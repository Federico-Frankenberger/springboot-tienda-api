package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.CategoriaDTO;
import com.federicofrankenberger.tienda_api.exception.NotFoundException;
import com.federicofrankenberger.tienda_api.mapper.Mapper;
import com.federicofrankenberger.tienda_api.model.Categoria;
import com.federicofrankenberger.tienda_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    @Override
    public CategoriaDTO save(CategoriaDTO dto) {
        Categoria categoria = Categoria.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
        return Mapper.toDTO(repo.save(categoria));
    }

    @Override
    public CategoriaDTO update(Long id, CategoriaDTO dto) {
        Categoria cat = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Categoria no encontrada"));
        cat.setNombre(dto.getNombre());
        cat.setDescripcion(dto.getDescripcion());
        return Mapper.toDTO(repo.save(cat));
    }

    @Override
    public void delete(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Categoria no encontrada");
        }
        repo.deleteById(id);
    }

    @Override
    public CategoriaDTO findById(Long id) {
        Categoria cat = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Categoria no encontrada"));
        return Mapper.toDTO(cat);
    }

    @Override
    public List<CategoriaDTO> findAll() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }
}
