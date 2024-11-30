package com.app.farmacia.repositorio;

import com.app.farmacia.entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNombre(String nombre);
}
