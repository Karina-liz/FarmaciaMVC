package com.app.farmacia.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class NavegacionControlador {
    @GetMapping("/ListaEmpleados")
    public String mostrarMenuE(Model model) {
        return "empleados"; 
    }
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
