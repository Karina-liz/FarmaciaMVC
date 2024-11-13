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

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Venta() {
    }

    public Venta(String idVenta, LocalDateTime fechaVenta, Cliente cliente, String tipoVenta, Local local, Pago pago,
            Integer cantidadProducto, BigDecimal importe) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.local = local;
        this.pago = pago;
        this.cantidadProducto = cantidadProducto;
        this.importe = importe;
    }

    // Getters y Setters
    
}

