package com.app.farmacia.repositorio;

import com.app.farmacia.entidad.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDAO extends JpaRepository<Empleado, String> {

}

