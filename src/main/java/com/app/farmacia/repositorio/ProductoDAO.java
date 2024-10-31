package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmacia.entidad.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
