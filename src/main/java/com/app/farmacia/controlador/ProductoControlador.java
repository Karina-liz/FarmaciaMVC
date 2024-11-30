package com.app.farmacia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.app.farmacia.entidad.Categoria;
import com.app.farmacia.entidad.Cliente;
import com.app.farmacia.entidad.Producto;
import com.app.farmacia.servicio.ProductoServicio; // Asegúrate de que esta clase exista
import com.app.farmacia.servicio.ClienteServicio;
import jakarta.servlet.http.HttpSession;

import com.app.farmacia.servicio.CategoriaServicio; // Asegúrate de que esta clase exista
import java.io.IOException;
import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    // Petición GET para listar productos
    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoServicio.listarProductos());
        return "productos"; // retorna el archivo de productos.html
    }

    // Petición GET para mostrar formulario de creación de producto
    @GetMapping("/productos/nuevo")
    public String mostrarFormularioCrearProducto(Model model) {
        // Crear un nuevo objeto Producto
        model.addAttribute("producto", new Producto());
        
        // Obtener la lista de categorías desde el servicio
        List<Categoria> categorias = categoriaServicio.obtenerTodasLasCategorias();
        
        // Añadir la lista de categorías al modelo
        model.addAttribute("categorias", categorias);

        // Devolver la vista crear_productos.html
        return "crear_productos";
    }

    // Petición POST para guardar un nuevo producto
    @PostMapping("/productos")
    public String guardarProducto(@RequestPart MultipartFile file, @ModelAttribute("producto") Producto producto) throws IOException {
        productoServicio.guardarProducto(producto, file);
        return "redirect:/productos";
    }


    // Petición GET para mostrar formulario de edición de producto
    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", productoServicio.obtenerProductoPorId(id));
        List<Categoria> categorias = categoriaServicio.obtenerTodasLasCategorias();
        
        // Añadir la lista de categorías al modelo
        modelo.addAttribute("categorias", categorias);
        return "editar_productos";
    }

    // Petición POST para actualizar un producto
    @PostMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Long id, @RequestPart MultipartFile file, @ModelAttribute("producto") Producto producto) throws IOException {
        // Obtener la categoría del formulario (usando el ID de la categoría)
        Long categoriaId = producto.getCategoria().getId();
        Categoria categoria = categoriaServicio.obtenerCategoriaPorId(categoriaId);

        // Asignar la categoría al producto
        producto.setCategoria(categoria);

        // Llamar al servicio para actualizar el producto
        productoServicio.actualizarProducto(producto, file);
        return "redirect:/productos"; // Redirige a la página de productos
    }

    // Petición GET para eliminar un producto
    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id) throws IOException{
        productoServicio.eliminarProducto(id);
        return "redirect:/productos";
    }

    // Petición GET para mostrar el catálogo de productos
    @GetMapping("/catalogo")
public String mostrarCatalogo(Model model, HttpSession session) {
    // Verificar si el email del cliente está en la sesión
    String email = (String) session.getAttribute("clienteEmail");

    if (email != null) {
        Cliente cliente = clienteServicio.buscarPorEmail(email);
        if (cliente != null) {
            // Agregar al modelo el nombre del cliente, si es necesario
            model.addAttribute("nombreCliente", cliente.getNombres());
        }
    }

    // Agregar los productos al modelo
    model.addAttribute("productos", productoServicio.listarProductos());
    
    // Devolver la vista del catálogo
    return "catalogo";
}
}
