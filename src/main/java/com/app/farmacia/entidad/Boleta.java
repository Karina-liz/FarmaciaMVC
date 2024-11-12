package com.app.farmacia.entidad;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @Column(name = "ID_Boleta")
    private String idBoleta;

    @Column(name = "CostoTotal", nullable = false)
    private BigDecimal costoTotal;

    @Column(name = "Vuelto", nullable = false)
    private BigDecimal vuelto;

    @ManyToOne
    @JoinColumn(name = "ID_Venta", referencedColumnName = "ID_Venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "ID_Pago", referencedColumnName = "ID_Pago")
    private Pago pago;

    // Getters y Setters
}
