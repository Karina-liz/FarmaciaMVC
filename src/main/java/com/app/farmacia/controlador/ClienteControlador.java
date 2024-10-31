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
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;
    // peticion get para listar clientes

    @GetMapping({ "/clientes"})
    public String listarClientes(Model modelo, HttpSession session) {
        String puesto = (String) session.getAttribute("empleadoPuesto");
        
        if (puesto == null || !puesto.toLowerCase().equals("administrador")) {
            return "redirect:/login";
        }
        
        modelo.addAttribute("clientes", clienteServicio.listarClientes());
        return "clientes";
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

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Integer id, HttpSession session) {
        String puesto = (String) session.getAttribute("empleadoPuesto");
        
        if (puesto == null || !puesto.toLowerCase().equals("administrador")) {
            return "redirect:/login";
        }
        
        clienteServicio.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
