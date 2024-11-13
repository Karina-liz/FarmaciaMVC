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

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Pago() {
    }

    public Pago(String idPago, String estadoPago, String tipoPago) {
        this.idPago = idPago;
        this.estadoPago = estadoPago;
        this.tipoPago = tipoPago;
    }

    // Getters y Setters
    
}

