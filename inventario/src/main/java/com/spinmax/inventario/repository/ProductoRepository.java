package com.spinmax.inventario.repository;

import com.spinmax.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
