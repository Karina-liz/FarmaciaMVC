package com.app.farmacia.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import com.app.farmacia.validacion.TelefonoValido;



@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @NotBlank(message = "El apellido es requerido")
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @NotBlank(message = "El DNI es requerido")
    @Pattern(regexp = "^[0-9]{8}$", message = "El DNI debe tener 8 dígitos numéricos")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @NotEmpty(message = "El correo es requerido")
    @Email(message = "El correo no es valido")
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @NotBlank(message = "La clave es requerida")
    @Column(name = "clave", nullable = false, length = 50)
    private String clave;

    @NotNull(message = "El teléfono es requerido")
    @TelefonoValido
    @Column(name = "telefono", nullable = false)
    private int telefono;

    @NotBlank(message = "La direccion es requerida")
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente(Integer id, String nombres, String apellidos, String dni, String email, String clave, int telefono,
            String direccion, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }
/* 
    //constructor para crear un cliente sin id (PRUEBA)
    public Cliente(String nombres, String apellidos, String dni, String email, String clave, int telefono, String direccion, LocalDateTime fechaRegistro) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }*/

    public Cliente() {
    }

    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email + ", clave=" + clave + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaRegistro=" + fechaRegistro + "]";
    }


}
