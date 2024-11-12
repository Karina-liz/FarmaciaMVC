package com.app.farmacia.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @Column(name = "ID_Pago")
    private String idPago;

    @Column(name = "EstadoPago", nullable = false)
    private String estadoPago;

    @Column(name = "TipoPago", nullable = false)
    private String tipoPago;

    // Getters y Setters
}

