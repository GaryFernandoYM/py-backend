package com.spinmax.inventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nombre;

    private String descripcion;

    private String codigo;

    private double precio;

    private int stock;

    private int stockminimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Categoria categoria;
}
