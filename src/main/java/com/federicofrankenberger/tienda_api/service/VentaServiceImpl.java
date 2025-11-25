package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.VentaDTO;
import com.federicofrankenberger.tienda_api.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository repo;

    @Override
    public VentaDTO save(VentaDTO dto) {
        return null;
    }

    @Override
    public VentaDTO update(Long aLong, VentaDTO dto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<VentaDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<VentaDTO> findAll() {
        return List.of();
    }
}
