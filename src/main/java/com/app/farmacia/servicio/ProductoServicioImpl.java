package com.app.farmacia.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.farmacia.entidad.Producto;
import com.app.farmacia.repositorio.ProductoDAO;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public List<Producto> listarProductos() {
        return productoDAO.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDAO.deleteById(id);
    }
}