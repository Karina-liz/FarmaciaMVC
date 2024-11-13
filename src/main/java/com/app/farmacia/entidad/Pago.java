package com.app.farmacia.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @Column(name = "ID_Pago",length = 50)
    private String idPago;

    @Column(name = "EstadoPago", nullable = false, length = 10)
    private String estadoPago;

    @Column(name = "TipoPago", nullable = false, length = 10)
    private String tipoPago;

    // Getters y Setters
}

