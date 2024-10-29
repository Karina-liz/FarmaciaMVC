package com.app.farmacia.servicio;

import java.util.List;
import com.app.farmacia.entidad.Producto;

public interface ProductoServicio {

    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto);

    Producto obtenerProductoPorId(Long id);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Long id);
}