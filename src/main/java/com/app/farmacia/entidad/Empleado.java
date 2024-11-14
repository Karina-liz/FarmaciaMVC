package com.app.farmacia.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Empleado;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "clave", nullable = false, length = 50)
    private String clave;

    @Column(name = "telefono", nullable = false, length = 11)
    private int telefono;

    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    @Column(name = "dni", nullable = false, length = 50,unique = true)
    private String dni;

    @Column(name = "salario", nullable = false)
    private double salario;

    @ManyToOne
    @JoinColumn(name = "ID_Local")
    private Local local;

    public Empleado() {
        
    }

    public Empleado(Long id, String nombre, String apellido, String email, String clave, int telefono, String puesto,
            String dni, double salario) {
        this.ID_Empleado = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.puesto = puesto;
        this.dni = dni;
        this.salario = salario;
        //this.local = new Local("L01", "PPSede_1", "Av -A", "Puente Piedra"); // Asignar Local con id_local "L01"
        
    }

    //constructor para crear un empleado sin id (PRUEBA)
    /*public Empleado(String nombre, String apellido, String email, String clave, int telefono, String puesto,
            String dni, double salario) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.puesto = puesto;
        this.dni = dni;
        this.salario = salario;
    } */

    // Getters y Setters
    public Long getId() {
        return ID_Empleado;
    }

    public void setId(Long id) {
        this.ID_Empleado= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + ID_Empleado + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", clave="
                + clave + ", telefono=" + telefono + ", puesto=" + puesto + ", dni=" + dni + ", salario=" + salario
                + "]";
    }

}
