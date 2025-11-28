package com.federicofrankenberger.tienda_api.controller;

import com.federicofrankenberger.tienda_api.dto.SucursalDTO;
import com.federicofrankenberger.tienda_api.service.SucursalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalServiceImpl sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> traerSucursales() {
        return ResponseEntity.ok(sucursalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDTO> traerSurcursal(@PathVariable Long id){
        return ResponseEntity.ok(sucursalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursalDTO){
        SucursalDTO creado =  sucursalService.save(sucursalDTO);
        return ResponseEntity.created(URI.create("/api/sucursales"+ creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> actualizarSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO){
        return ResponseEntity.ok(sucursalService.update(id, sucursalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Long id){
        sucursalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
