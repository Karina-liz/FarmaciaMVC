package com.app.farmacia.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @Column(name = "ID_Local",length = 50)
    private String idLocal;

    @Column(name = "Local", nullable = false,length = 50)
    private String local;

    @Column(name = "Direccion", nullable = false,length = 50)
    private String direccion;

    @Column(name = "Cuidad", nullable = false , length = 50)
    private String cuidad;

    // Getters y Setters
}

