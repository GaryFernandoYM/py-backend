package com.spinmax.cliente.controller;

import com.spinmax.cliente.entity.Cliente;
import com.spinmax.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping()
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok().body(clienteService.list());
    }

    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @PutMapping()
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listById(@PathVariable(required = true) Integer id) {
        Optional<Cliente> cliente = clienteService.listById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        clienteService.deleteById(id);
        return "";
    }

}
