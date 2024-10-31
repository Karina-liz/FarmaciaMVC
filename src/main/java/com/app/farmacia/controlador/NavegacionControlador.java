package com.app.farmacia.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionControlador {
    
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

    @GetMapping("/Catalogo")
    public String mostrarCatalogo(Model model) {
        return "Catalogo"; 
    }

    @GetMapping("/PantallaPrincipal")
    public String mostrarPrincipal(Model model) {
        return "PantallaPrincipal"; 
    }

    @GetMapping("/Promociones")
    public String mostrarPromociones(Model model) {
        return "Promociones"; 
    }
}
