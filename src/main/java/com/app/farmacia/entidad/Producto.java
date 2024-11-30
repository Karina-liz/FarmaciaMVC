package com.app.farmacia.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.math.BigDecimal;



@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Long ID_Producto;

    @Column(name = "NombreProducto", nullable = false, length = 100)
    private String NombreProducto;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(name = "PrecioVenta", nullable = false, precision = 10, scale = 2)
    private BigDecimal PrecioVenta;

    @Column(name = "PrincipioActivo", nullable = false, length = 100)
    private String PrincipioActivo;

    @Column(name = "Presentacion", nullable = false, length = 50)
    private String Presentacion;

    @Column(name = "Laboratorio", nullable = false, length = 50)
    private String Laboratorio;

    @Column(name = "Foto", nullable = true)
    private String Foto;

    @ManyToOne
    @JoinColumn(name = "ID_Lote")
    private Lote lote;

    @Column(name = "FechaVencimiento", nullable = false)
    private LocalDate FechaVencimiento;

    public Producto() {
    }

    public Producto(Long ID_Producto, String NombreProducto, BigDecimal PrecioVenta,
                    String PrincipioActivo, String Presentacion, String Laboratorio, String Foto, 
                    Lote lote, LocalDate FechaVencimiento) {
        this.ID_Producto = ID_Producto;
        this.NombreProducto = NombreProducto;
        this.PrecioVenta = PrecioVenta;
        this.PrincipioActivo = PrincipioActivo;
        this.Presentacion = Presentacion;
        this.Laboratorio = Laboratorio;
        this.Foto = Foto;
        this.lote = lote;
        this.FechaVencimiento = FechaVencimiento;
    }

    // Getters y Setters
    public Long getIdProducto() {
        return ID_Producto;
    }

    public void setIdProducto(Long ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(BigDecimal PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getPrincipioActivo() {
        return PrincipioActivo;
    }

    public void setPrincipioActivo(String PrincipioActivo) {
        this.PrincipioActivo = PrincipioActivo;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public String getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(String Laboratorio) {
        this.Laboratorio = Laboratorio;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public LocalDate getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    @Override
public String toString() {
    return "Producto [idProducto=" + ID_Producto + ", NombreProducto=" + NombreProducto + ", categoria=" + categoria +
            ", precioVenta=" + PrecioVenta + ", principioActivo=" + PrincipioActivo + ", presentacion=" + Presentacion +
            ", laboratorio=" + Laboratorio + ", foto=" + Foto + ", lote=" + lote + ", fechaVencimiento=" + FechaVencimiento + "]";
}

}
