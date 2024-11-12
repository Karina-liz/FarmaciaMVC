package com.app.farmacia.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @Column(name = "ID_Local")
    private String idLocal;

    @Column(name = "Local", nullable = false)
    private String local;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @Column(name = "Cuidad", nullable = false)
    private String cuidad;

    // Getters y Setters
}

