package com.app.farmacia.validacion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidadorTelefono.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelefonoValido {
    String message() default "El número debe tener 7 dígitos (teléfono) o 9 dígitos (celular)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 