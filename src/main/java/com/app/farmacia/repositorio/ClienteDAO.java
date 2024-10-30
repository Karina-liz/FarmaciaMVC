package com.app.farmacia.repositorio;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.farmacia.entidad.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
