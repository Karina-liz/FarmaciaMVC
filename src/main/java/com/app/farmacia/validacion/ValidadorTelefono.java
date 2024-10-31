package com.app.farmacia.validacion;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorTelefono implements ConstraintValidator<TelefonoValido, Integer> {
    @Override
    public boolean isValid(Integer telefono, ConstraintValidatorContext context) {
        if (telefono == null) return false;
        
        String numeroStr = String.valueOf(telefono);
        int longitud = numeroStr.length();
        
        if (longitud != 7 && longitud != 9) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                "Debe ingresar " + (longitud < 9 ? "9 dígitos para celular" : "7 dígitos para teléfono fijo"))
                .addConstraintViolation();
            return false;
        }
        return true;
    }
} 