package com.app.farmacia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.farmacia.repositorio.ClienteDAO;
import com.app.farmacia.entidad.Cliente;


@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteDAO clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepositorio.findById(id).get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        return clienteRepositorio.findByEmail(email);
    }
}
