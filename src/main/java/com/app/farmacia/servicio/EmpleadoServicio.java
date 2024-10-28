package com.app.farmacia.servicio;

import com.app.farmacia.entidad.Empleado;

import java.util.List;

public interface EmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId(Long id);

    public Empleado actualizarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Long id);
}
