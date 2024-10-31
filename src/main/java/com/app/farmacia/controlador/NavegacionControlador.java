package com.app.farmacia.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import com.app.farmacia.entidad.Cliente;
import com.app.farmacia.entidad.Empleado;
import com.app.farmacia.servicio.ClienteServicio;
import com.app.farmacia.servicio.EmpleadoServicio;

@Controller
public class NavegacionControlador {
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping({"/", "/login"})
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam("username") String email,
                             @RequestParam("password") String password,
                             Model model,
                             HttpSession session) {
        // Primero intentar autenticar como empleado
        Empleado empleado = empleadoServicio.buscarPorEmail(email);
        if (empleado != null && empleado.getClave().equals(password)) {
            if (empleado.getPuesto().toLowerCase().equals("administrador")) {
                session.setAttribute("empleadoId", empleado.getId());
                session.setAttribute("empleadoEmail", empleado.getEmail());
                session.setAttribute("empleadoPuesto", empleado.getPuesto());
                return "redirect:/empleados";
            }
        }
        
        // Si no es administrador, intentar autenticar como cliente
        Cliente cliente = clienteServicio.buscarPorEmail(email);
        if (cliente != null && cliente.getClave().equals(password)) {
            session.setAttribute("clienteId", cliente.getId());
            session.setAttribute("clienteEmail", cliente.getEmail());
            model.addAttribute("nombreCliente", cliente.getNombres());
            return "redirect:/nosotros";
        }
        
        model.addAttribute("error", "Correo o contraseña incorrectos");
        return "login";
    }

    @GetMapping("/ListaEmpleados")
    public String mostrarMenuE(Model model) {
        return "empleados"; 
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros(Model model, HttpSession session) {
        String email = (String) session.getAttribute("clienteEmail");
        
        if (email != null) {
            Cliente cliente = clienteServicio.buscarPorEmail(email);
            if (cliente != null) {
                model.addAttribute("nombreCliente", cliente.getNombres());
            }
        }
        return "Nosotros";
    }

    @GetMapping("/ListaLote")
    public String mostrarMenuL(Model model) {
        return "lotes"; 
    }

    @GetMapping("/ListaProductos")
    public String mostrarMenuP(Model model) {
        return "productos"; 
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
