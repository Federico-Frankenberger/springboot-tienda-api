package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.ClienteDTO;
import com.federicofrankenberger.tienda_api.exception.DuplicateResourceException;
import com.federicofrankenberger.tienda_api.exception.NotFoundException;
import com.federicofrankenberger.tienda_api.mapper.Mapper;
import com.federicofrankenberger.tienda_api.model.Cliente;
import com.federicofrankenberger.tienda_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repo;

    @Override
    public ClienteDTO save(ClienteDTO dto) {

        if(repo.existsByDni(dto.getDni())){
            throw new DuplicateResourceException("DNI ya registrado");
        }

        if(repo.existsByEmail(dto.getEmail())){
            throw new DuplicateResourceException("Email ya registrado");
        }

        if(repo.existsByTelefono(dto.getTelefono())){
            throw new DuplicateResourceException("Telefono ya registrado");
        }

        Cliente cliente = Cliente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .dni(dto.getDni())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();

        return Mapper.toDTO(repo.save(cliente));
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO dto) {

        Cliente cliente = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Cliente no encontrado"));

        if (repo.existsByDniAndIdNot(dto.getDni(), id)) {
            throw new DuplicateResourceException("DNI ya registrado");
        }

        if (repo.existsByEmailAndIdNot(dto.getEmail(), id)) {
            throw new DuplicateResourceException("Email ya registrado");
        }

        if (repo.existsByTelefonoAndIdNot(dto.getTelefono(), id)) {
            throw new DuplicateResourceException("Telefono ya registrado");
        }


        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        return Mapper.toDTO(repo.save(cliente));
    }

    @Override
    public void delete(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Cliente no encontrado");
        }
        repo.deleteById(id);
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente cliente = repo.findById(id)
                .orElseThrow(()->new NotFoundException("Cliente no encontrado"));
        return Mapper.toDTO(cliente);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }
}
