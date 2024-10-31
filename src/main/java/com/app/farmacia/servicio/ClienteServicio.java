package com.app.farmacia.servicio;

import com.app.farmacia.entidad.Cliente;

import java.util.List;

public interface ClienteServicio {
    List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente obtenerClientePorId(Integer id);

    public Cliente actualizarCliente(Cliente cliente);
    
    public void eliminarCliente(Integer id);

    public Cliente buscarPorEmail(String email);
}
