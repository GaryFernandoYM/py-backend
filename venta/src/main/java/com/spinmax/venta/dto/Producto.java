package com.spinmax.venta.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Producto {

    private Integer id;

    private String nombre;

    private String descripcion;

    private String codigo;

    private double precio;

    private int stock;

    private int stockminimo;

    private Categoria categoria;

}
