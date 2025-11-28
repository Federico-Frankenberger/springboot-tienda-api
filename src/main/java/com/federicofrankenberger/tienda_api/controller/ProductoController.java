package com.federicofrankenberger.tienda_api.controller;

import com.federicofrankenberger.tienda_api.dto.ProductoDTO;
import com.federicofrankenberger.tienda_api.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> traerProductos(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> traerProducto(@PathVariable Long id){
        return ResponseEntity.ok(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO){
        ProductoDTO creado =  productoService.save(productoDTO);
        return ResponseEntity.created(URI.create("/api/productos"+ creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.update(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
