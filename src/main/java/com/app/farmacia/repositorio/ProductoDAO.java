package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.app.farmacia.entidad.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.Categoria = :categoria")
List<Producto> findByCategoria(@Param("categoria") String categoria);
}

