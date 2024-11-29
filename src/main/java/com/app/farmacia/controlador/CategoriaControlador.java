package com.app.farmacia.controlador;

import com.app.farmacia.entidad.Categoria;
import com.app.farmacia.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaServicio.listarCategorias());
        return "categorias";  // Ruta a la vista "categorias.html"
    }

    // Mostrar el formulario para crear una nueva categoría
    @GetMapping("/nuevo")
public String mostrarFormularioCrearCategoria(Model model) {
    model.addAttribute("categoria", new Categoria());
    return "crear_categorias";  // Asegúrate de que el nombre coincida con el archivo
}

    // Guardar la nueva categoría
    @PostMapping
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaServicio.guardarCategoria(categoria);
        return "redirect:/categorias";  // Redirige al listado de categorías
    }

    // Mostrar el formulario para editar una categoría existente

    // Guardar los cambios de la categoría editada
    @PostMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long id, @ModelAttribute Categoria categoria) {
        categoriaServicio.actualizarCategoria(id, categoria);
        return "redirect:/categorias";  // Redirige al listado de categorías
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaServicio.obtenerCategoriaPorId(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "crear_categorias"; // Reutilizar formulario
        }
        return "redirect:/categorias"; // Si no existe la categoría
    }

    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaServicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}
