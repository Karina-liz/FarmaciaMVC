package com.app.farmacia.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.farmacia.entidad.Empleado;
import com.app.farmacia.repositorio.EmpleadoDAO;


@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    
    @Autowired
    private EmpleadoDAO empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepositorio.findById(id).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepositorio.deleteById(id);
    }
}

