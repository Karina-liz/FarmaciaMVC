package com.app.farmacia.controlador;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.app.farmacia.servicio.ProductoServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import com.app.farmacia.entidad.Producto;


@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    // Petición GET para listar productos
    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoServicio.listarProductos());
        return "productos"; // retorna el archivo de productos.html
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_productos";
    }

    @PostMapping("/productos")
    public String guardarProducto(@RequestPart MultipartFile file, @ModelAttribute("producto") Producto producto) throws IOException {
        productoServicio.guardarProducto(producto, file);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", productoServicio.obtenerProductoPorId(id));
        return "editar_productos";
    }

    @PostMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Long id, @RequestPart MultipartFile file, @ModelAttribute("producto") Producto producto) throws IOException {
        productoServicio.actualizarProducto(producto, file);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id) throws IOException{
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("productos", productoServicio.listarProductos());
        return "catalogo";
    }

    @RequestMapping("/productos/categoria")
    @ResponseBody
    public List<Producto> obtenerProductosPorCategoria(@RequestParam String Categoria) {
        // Obtén los productos según la categoría seleccionada
        if (Categoria.equals("Todos")) {
            return productoServicio.obtenerTodosLosProductos();
        } else {
            return productoServicio.obtenerProductosPorCategoria(Categoria);
        }
    }

}