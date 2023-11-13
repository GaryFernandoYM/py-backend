package com.spinmax.inventario.controller;

import com.spinmax.inventario.entity.Producto;
import com.spinmax.inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> list() {
        return ResponseEntity.ok().body(productoService.list());
    }

    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @PutMapping()
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.update(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Integer id) {
        Optional<Producto> cliente = productoService.listById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        productoService.deleteById(id);
        return "";
    }
}
