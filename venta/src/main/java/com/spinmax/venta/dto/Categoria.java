package com.spinmax.venta.dto;

import lombok.Data;

@Data
public class Categoria {

    private Integer id;

    private String nombre;

    private String descripcion;

    private boolean estado;
}
