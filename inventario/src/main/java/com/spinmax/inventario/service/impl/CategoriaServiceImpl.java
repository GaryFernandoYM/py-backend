package com.spinmax.inventario.service.impl;

import com.spinmax.inventario.entity.Categoria;
import com.spinmax.inventario.repository.CategoriaRepository;
import com.spinmax.inventario.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> list() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> listById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
