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

    // Getters y Setters
}

