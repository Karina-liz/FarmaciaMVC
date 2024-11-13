package com.app.farmacia.entidad;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @Column(name = "ID_Venta")
    private String idVenta;

    @Column(name = "FechaVenta", nullable = false)
    private LocalDateTime fechaVenta;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    private Cliente cliente;

    @Column(name = "TipoVenta", nullable = false, length = 10)
    private String tipoVenta;

    @ManyToOne
    @JoinColumn(name = "ID_Local")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "ID_Pago")
    private Pago pago;

    @Column(name = "CantidadProducto", nullable = false, length = 50)
    private Integer cantidadProducto;

    @Column(name = "Importe", nullable = false, precision = 7,scale = 2)
    private BigDecimal importe;

    // Getters y Setters
}
