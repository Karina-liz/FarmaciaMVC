package com.app.farmacia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ClienteControlador {
/* 
    @Autowired
    private EmpleadoServicio empleadoServicio;
    // peticion get para listar empleados
*/
    @GetMapping({ "/clientes"})
    public String listarClientes(Model modelo) {
        return "clientes"; // retorna el archivo de 
    }
/* 
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistrarEmpleado(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleado", empleado);
        return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", empleadoServicio.obtenerEmpleadoPorId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado,
            Model modelo) {
        Empleado empleadoExistente = empleadoServicio.obtenerEmpleadoPorId(id);
        empleadoExistente.setId(id);
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setClave(empleado.getClave());
        empleadoExistente.setDni(empleado.getDni());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setTelefono(empleado.getTelefono());
        empleadoExistente.setPuesto(empleado.getPuesto());
        empleadoExistente.setSalario(empleado.getSalario());

        empleadoServicio.actualizarEmpleado(empleadoExistente);

        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoServicio.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
*/
}
