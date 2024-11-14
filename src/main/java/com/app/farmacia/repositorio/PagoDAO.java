package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.farmacia.entidad.Pago;

public interface PagoDAO extends JpaRepository<Pago, String>{

}
