package com.spinmax.inventario.service.impl;

import com.spinmax.inventario.entity.Producto;
import com.spinmax.inventario.repository.ProductoRepository;
import com.spinmax.inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> list() {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> listById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}
