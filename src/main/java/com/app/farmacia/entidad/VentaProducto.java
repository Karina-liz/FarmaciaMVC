package com.app.farmacia.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "venta_producto")
public class VentaProducto {
    @Id
    @Column(name = "ID_VP")
    private String idVP;

    @ManyToOne
    @JoinColumn(name = "ID_Venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "ID_Producto")
    private Producto producto;

    public String getIdVP() {
        return idVP;
    }

    public void setIdVP(String idVP) {
        this.idVP = idVP;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public VentaProducto() {
    }

    public VentaProducto(String idVP, Venta venta, Producto producto) {
        this.idVP = idVP;
        this.venta = venta;
        this.producto = producto;
    }

    // Getters y Setters
    
}

