package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.ClienteDTO;
import com.federicofrankenberger.tienda_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repo;

    @Override
    public ClienteDTO save(ClienteDTO dto) {
        return null;
    }

    @Override
    public ClienteDTO update(Long aLong, ClienteDTO dto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<ClienteDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ClienteDTO> findAll() {
        return List.of();
    }
}
