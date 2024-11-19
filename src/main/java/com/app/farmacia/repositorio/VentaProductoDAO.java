package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.farmacia.entidad.VentaProducto;

public interface VentaProductoDAO extends JpaRepository<VentaProducto, String>{

}
