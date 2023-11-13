package com.spinmax.venta.entity;

import com.spinmax.venta.dto.Cliente;
import com.spinmax.venta.dto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Double cantidad;

    private Double precio;

    private Integer producto_id;

    @Transient
    private Producto producto;
    public VentaDetalle(){
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

}
