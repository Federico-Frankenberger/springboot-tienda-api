package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.SucursalDTO;
import com.federicofrankenberger.tienda_api.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository repo;

    @Override
    public SucursalDTO save(SucursalDTO dto) {
        return null;
    }

    @Override
    public SucursalDTO update(Long aLong, SucursalDTO dto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<SucursalDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<SucursalDTO> findAll() {
        return List.of();
    }
}
