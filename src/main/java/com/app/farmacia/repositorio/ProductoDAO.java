package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.app.farmacia.entidad.Producto;
import com.app.farmacia.entidad.Categoria;


@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
}

