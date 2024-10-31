package com.app.farmacia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.farmacia.entidad.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.farmacia.servicio.ClienteServicio;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;
    // peticion get para listar clientes

    @GetMapping({ "/clientes"})
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteServicio.listarClientes());
        return "clientes"; // retorna el archivo de 
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistrarCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/clientes/nuevo")
    public String guardarCliente(@Validated Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "crear_cliente";
        }
        try {
            cliente.setFechaRegistro(LocalDateTime.now());
            clienteServicio.guardarCliente(cliente);
            redirectAttributes.addFlashAttribute("msExito", "Te has registrado exitosamente");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msError", "Error: El correo ya está registrado");
            return "crear_cliente";
        }
    }


/*  
    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
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
