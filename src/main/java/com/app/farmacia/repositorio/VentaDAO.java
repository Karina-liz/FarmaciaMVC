package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.farmacia.entidad.Venta;

public interface VentaDAO extends JpaRepository<Venta, String>{

}
