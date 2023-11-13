package com.spinmax.venta.service.impl;

import com.spinmax.venta.dto.Cliente;
import com.spinmax.venta.dto.Producto;
import com.spinmax.venta.entity.Venta;
import com.spinmax.venta.entity.VentaDetalle;
import com.spinmax.venta.feign.ClienteFeign;
import com.spinmax.venta.feign.ProductoFeign;
import com.spinmax.venta.repository.VentaRepository;
import com.spinmax.venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProductoFeign productoFeign;

    @Override
    public List<Venta> list() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> listById(Integer id) {

        Venta venta = ventaRepository.findById(id).get();
        Cliente cliente = clienteFeign.listById(venta.getCliente_id()).getBody();
        List<VentaDetalle> ventaDetalles = venta.getDetalle().stream().map(ventaDetalle -> {
            Producto producto = productoFeign.listById(ventaDetalle.getProducto_id()).getBody();
            ventaDetalle.setProducto(producto);
            return ventaDetalle;
        }).collect(Collectors.toList());
        venta.setDetalle(ventaDetalles);
        venta.setCliente(cliente);
        return Optional.of(venta);

    }

    @Override
    public void deleteById(Integer id) {
        ventaRepository.deleteById(id);
    }
}
