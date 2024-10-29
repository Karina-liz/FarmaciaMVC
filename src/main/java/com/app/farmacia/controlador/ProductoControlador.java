package com.app.farmacia.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.app.farmacia.servicio.ProductoServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.farmacia.entidad.Producto;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio ProductoServicio;

    // Petición GET para listar productos
    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", ProductoServicio.listarProductos());
        return "productos"; // retorna el archivo de productos.html
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioDeRegistrarProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_productos";
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        ProductoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", ProductoServicio.obtenerProductoPorId(id));
        return "editar_productos";
    }

    @PostMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto,
                                     Model modelo) {
        Producto productoExistente = ProductoServicio.obtenerProductoPorId(id);
        productoExistente.setId(id);
        productoExistente.setNombreProducto(producto.getNombreProducto());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setPrincipioActivo(producto.getPrincipioActivo());
        productoExistente.setPresentacion(producto.getPresentacion());
        productoExistente.setLaboratorio(producto.getLaboratorio());

        ProductoServicio.actualizarProducto(productoExistente);

        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        ProductoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }
}