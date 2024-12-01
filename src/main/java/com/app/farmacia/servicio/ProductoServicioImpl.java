package com.app.farmacia.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.farmacia.entidad.Categoria;
import com.app.farmacia.entidad.Producto;
import com.app.farmacia.repositorio.CategoriaRepository;
import com.app.farmacia.repositorio.ProductoDAO;


import java.io.IOException;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoDAO productoDAO;

    @Autowired
    private UploadServicio uploadServicio;

    @Autowired
    private CategoriaRepository categoriaDAO;


    @Override
    public List<Producto> listarProductos() {
        return productoDAO.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto, MultipartFile file) throws IOException {
        String nombreArchivo = uploadServicio.saveUpload(file);
        producto.setFoto(nombreArchivo);
        return productoDAO.save(producto);
    }


    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(Producto producto, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String nombreArchivo = uploadServicio.saveUpload(file);
            producto.setFoto(nombreArchivo);
        }
        return productoDAO.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDAO.deleteById(id);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.findAll();
    }
    
    @Override
    public List<Producto> buscarPorNombre(String NombreProducto) {
        return productoDAO.findByNombreProductoContainingIgnoreCase(NombreProducto);
    }

    @Override
    public List<Producto> buscarPorCategoria(String categoria) {
        return productoDAO.findByCategoriaNombreContainingIgnoreCase(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaDAO.findAll();
    }
}