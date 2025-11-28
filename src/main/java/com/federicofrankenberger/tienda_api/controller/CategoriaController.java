package com.federicofrankenberger.tienda_api.controller;

import com.federicofrankenberger.tienda_api.dto.CategoriaDTO;
import com.federicofrankenberger.tienda_api.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> traerCategorias(){
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> traerCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO creado =  categoriaService.save(categoriaDTO);
        return ResponseEntity.created(URI.create("/api/categorias"+ creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.ok(categoriaService.update(id, categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
