package com.spinmax.venta.dto;

import lombok.Data;

@Data
public class Cliente {
    private Integer id;

    private String nombres;

    private String apellidos;

    private String documento;

    private boolean sexo;

    private String direccion;

    private String telefono;
}
