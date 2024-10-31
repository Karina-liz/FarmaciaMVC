package com.app.farmacia.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.farmacia.entidad.Empleado;

@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, Long> {
    Empleado findByEmail(String email);
}
