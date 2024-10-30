package com.app.farmacia.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 50, unique = true)
    private String dni;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "clave", nullable = false, length = 50)
    private String clave;

    @Column(name = "celular", nullable = false, length = 11)
    private int telefono;

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
    }

    public Cliente() {
    }

    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email + ", clave=" + clave + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaRegistro=" + fechaRegistro + "]";
    }


}
