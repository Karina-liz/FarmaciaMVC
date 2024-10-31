package com.app.farmacia.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import com.app.farmacia.entidad.Cliente;
import com.app.farmacia.servicio.ClienteServicio;

@Controller
public class NavegacionControlador {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping({"/", "/login"})
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam("username") String email,
                             @RequestParam("password") String password,
                             Model model,
                             HttpSession session) {
        Cliente cliente = clienteServicio.buscarPorEmail(email);
        
        if (cliente != null && cliente.getClave().equals(password)) {
            // Usuario válido - guardar en sesión
            session.setAttribute("clienteId", cliente.getId());
            session.setAttribute("clienteEmail", cliente.getEmail());
            return "Nosotros"; // Redirige a la página principal
        } else {
            // Usuario inválido
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/ListaEmpleados")
    public String mostrarMenuE(Model model) {
        return "empleados"; 
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros() {
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

}
