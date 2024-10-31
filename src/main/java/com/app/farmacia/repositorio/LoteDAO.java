package com.app.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farmacia.entidad.Lote;

@Repository
public interface LoteDAO extends JpaRepository<Lote, Long>{

}
