package com.spinmax.venta.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spinmax.venta.dto.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String serie;

    private String numero;

    private String descripcion;

    private Integer cliente_id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<VentaDetalle> detalle;

    @Transient
    private Cliente cliente;
}
