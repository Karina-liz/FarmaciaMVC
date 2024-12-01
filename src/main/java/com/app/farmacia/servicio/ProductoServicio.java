package com.app.farmacia.servicio;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.app.farmacia.entidad.Producto;
import java.io.IOException;

public interface ProductoServicio {

    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto, MultipartFile file) throws IOException;

   Producto obtenerProductoPorId(Long id);

    Producto actualizarProducto(Producto producto, MultipartFile file) throws IOException;

    void eliminarProducto(Long id) throws IOException;
    
    List<Producto> obtenerTodosLosProductos();
}