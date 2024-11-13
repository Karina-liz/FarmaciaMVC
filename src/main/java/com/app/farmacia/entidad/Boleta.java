package com.app.farmacia.entidad;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @Column(name = "ID_Boleta", length = 50)
    private String idBoleta;

    @Column(name = "CostoTotal", nullable = false,precision = 7,scale = 2)
    private BigDecimal costoTotal;

    @Column(name = "Vuelto", nullable = false, precision = 5,scale = 2)
    private BigDecimal vuelto;

    @ManyToOne
    @JoinColumn(name = "ID_Venta", referencedColumnName = "ID_Venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "ID_Pago", referencedColumnName = "ID_Pago")
    private Pago pago;

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

    public BigDecimal getVuelto() {
        return vuelto;
    }

    public void setVuelto(BigDecimal vuelto) {
        this.vuelto = vuelto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Boleta() {
    }

    public Boleta(String idBoleta, BigDecimal costoTotal, BigDecimal vuelto, Venta venta, Pago pago) {
        this.idBoleta = idBoleta;
        this.costoTotal = costoTotal;
        this.vuelto = vuelto;
        this.venta = venta;
        this.pago = pago;
    }

    // Getters y Setters
    
}
