package com.spinmax.inventario.controller;

import com.spinmax.inventario.entity.Categoria;
import com.spinmax.inventario.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<Categoria>> list() {
        return ResponseEntity.ok().body(categoriaService.list());
    }

    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @PutMapping()
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.update(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(categoriaService.listById(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        categoriaService.deleteById(id);
        return "";
    }
}
