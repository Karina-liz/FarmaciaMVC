package com.app.farmacia.controlador;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.app.farmacia.servicio.ProductoServicio;

import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.app.farmacia.entidad.Producto;

@Controller

public class ProductoControlador {

    @Autowired
    private ProductoServicio ProductoServicio;

 

    @Value("${app.upload.dir}")
    private String uploadDir;

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
    public String guardarProducto(@ModelAttribute("producto") @Valid Producto producto,
                                  BindingResult bindingResult,
                                  @RequestParam(value = "foto", required = false) MultipartFile foto) {
        // Validar el producto
    

        if (bindingResult.hasErrors()) {
            return "crear_productos"; // Regresar al formulario si hay errores
        }

        // Asegúrate de que el directorio exista
        try {
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (foto != null && !foto.isEmpty()) {
            try {
                String nombreArchivo = Path.of(foto.getOriginalFilename()).getFileName().toString();
                Path ruta = Paths.get(uploadDir, nombreArchivo);
                Files.copy(foto.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
                producto.setFoto("/uploads/" + nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Si no se subió una foto, se puede dejar el campo como null
            producto.setFoto(null);
        }
        
        // Guardar el producto
        try {
            ProductoServicio.guardarProducto(producto);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error, tal vez redirigir a un formulario de error
        }
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
        productoExistente.setIdProducto(id);
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