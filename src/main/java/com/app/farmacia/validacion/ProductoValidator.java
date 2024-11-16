package com.app.farmacia.validacion;

import com.app.farmacia.entidad.Producto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Producto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Producto producto = (Producto) target;

        // Validar el nombre del producto
        if (producto.getNombreProducto() == null || producto.getNombreProducto().isEmpty()) {
            errors.rejectValue("NombreProducto", "error.nombreProducto", "El nombre del producto es obligatorio.");
        }

        // Validar la categoría
        if (producto.getCategoria() == null || producto.getCategoria().isEmpty()) {
            errors.rejectValue("Categoria", "error.categoria", "La categoría es obligatoria.");
        }

        // Validar el precio de venta
        if (producto.getPrecioVenta() <= 0) {
            errors.rejectValue("PrecioVenta", "error.precioVenta", "El precio de venta debe ser mayor que cero.");
        }

        // Validar el principio activo
        if (producto.getPrincipioActivo() == null || producto.getPrincipioActivo().isEmpty()) {
            errors.rejectValue("PrincipioActivo", "error.principioActivo", "El principio activo es obligatorio.");
        }

        // Validar la presentación
        if (producto.getPresentacion() == null || producto.getPresentacion().isEmpty()) {
            errors.rejectValue("Presentacion", "error.presentacion", "La presentación es obligatoria.");
        }

        // Validar el laboratorio
        if (producto.getLaboratorio() == null || producto.getLaboratorio().isEmpty()) {
            errors.rejectValue("Laboratorio", "error.laboratorio", "El laboratorio es obligatorio.");
        }
    }
}
