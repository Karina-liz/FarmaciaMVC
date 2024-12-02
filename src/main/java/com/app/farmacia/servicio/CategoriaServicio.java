package com.app.farmacia.servicio;

import com.app.farmacia.entidad.Categoria;
import java.util.List;

public interface CategoriaServicio {
    List<Categoria> listarCategorias();
    void guardarCategoria(Categoria categoria);
    Categoria obtenerCategoriaPorId(Long id);
    void actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
    List<Categoria> obtenerTodasLasCategorias();
    Categoria buscarPorNombre(String nombre);
}
