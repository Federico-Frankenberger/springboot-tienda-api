package com.federicofrankenberger.tienda_api.controller;

import com.federicofrankenberger.tienda_api.dto.EstadoVentaDTO;
import com.federicofrankenberger.tienda_api.dto.VentaDTO;
import com.federicofrankenberger.tienda_api.model.EstadoVenta;
import com.federicofrankenberger.tienda_api.service.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaServiceImpl ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> traerVentas() {
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> traerVenta(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO){
        VentaDTO creado =  ventaService.save(ventaDTO);
        return ResponseEntity.created(URI.create("/api/sucursales"+ creado.getId())).body(creado);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<VentaDTO> actualizarEstadoVenta(@PathVariable Long id, @RequestBody EstadoVentaDTO estadoVenta){
        return ResponseEntity.ok(ventaService.cambiarEstado(id, estadoVenta.getEstado()));
    }

}
