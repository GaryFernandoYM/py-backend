package com.spinmax.inventario.repository;

import com.spinmax.inventario.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
