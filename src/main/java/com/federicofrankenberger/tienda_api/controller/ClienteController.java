package com.federicofrankenberger.tienda_api.controller;

import com.federicofrankenberger.tienda_api.dto.ClienteDTO;
import com.federicofrankenberger.tienda_api.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> traerClientes(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> traerCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO creado =  clienteService.save(clienteDTO);
        return ResponseEntity.created(URI.create("/api/clientes"+ creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.update(id, clienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
