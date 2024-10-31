package com.app.farmacia.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class NavegacionControlador {
    @GetMapping("/")
    public String mostrarLogin() {
        return "login";  // llama a login.html
    }

    @GetMapping("/ListaEmpleados")
    public String mostrarMenuE(Model model) {
        return "empleados"; 
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
