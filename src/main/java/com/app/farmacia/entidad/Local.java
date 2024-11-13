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

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public Local() {
    }

    public Local(String idLocal, String local, String direccion, String cuidad) {
        this.idLocal = idLocal;
        this.local = local;
        this.direccion = direccion;
        this.cuidad = cuidad;
    }

    // Getters y Setters

    
}

