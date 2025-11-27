package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.SucursalDTO;
import com.federicofrankenberger.tienda_api.exception.NotFoundException;
import com.federicofrankenberger.tienda_api.mapper.Mapper;
import com.federicofrankenberger.tienda_api.model.Sucursal;
import com.federicofrankenberger.tienda_api.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository repo;

    @Override
    public SucursalDTO save(SucursalDTO dto) {
        Sucursal sucursal = Sucursal.builder()
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .build();
        return Mapper.toDTO(repo.save(sucursal));
    }

    @Override
    public SucursalDTO update(Long id, SucursalDTO dto) {
        Sucursal sucursal = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Sucursal no encontrada"));
        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());
        return Mapper.toDTO(repo.save(sucursal));
    }

    @Override
    public void delete(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Sucursal no encontrada");
        }
        repo.deleteById(id);
    }

    @Override
    public SucursalDTO findById(Long id) {
        Sucursal sucursal = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Sucursal no encontrada"));
        return Mapper.toDTO(sucursal);
    }

    @Override
    public List<SucursalDTO> findAll() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }
}
