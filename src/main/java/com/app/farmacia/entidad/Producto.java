package com.app.farmacia.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Long ID_Producto;

    @Column(name = "NombreProducto", nullable = false, length = 100)
    private String NombreProducto;

    @Column(name = "Categoria", nullable = false, length = 50)
    private String Categoria;

    @Column(name = "PrecioVenta", nullable = false)
    private double PrecioVenta;

    @Column(name = "PrincipioActivo", nullable = false, length = 100)
    private String PrincipioActivo;

    @Column(name = "Presentacion", nullable = false, length = 50)
    private String Presentacion;

    @Column(name = "Laboratorio", nullable = false, length = 50)
    private String Laboratorio;

    @ManyToOne
    @JoinColumn(name = "ID_Lote")
    private Lote lote;

    public Producto() {
    }

    public Producto(Long ID_Producto, String NombreProducto, String Categoria, double PrecioVenta, String PrincipioActivo, String Presentacion, String Laboratorio) {
        this.ID_Producto = ID_Producto;
        this.NombreProducto = NombreProducto;
        this.Categoria = Categoria;
        this.PrecioVenta = PrecioVenta;
        this.PrincipioActivo = PrincipioActivo;
        this.Presentacion = Presentacion;
        this.Laboratorio = Laboratorio;
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

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
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

    @Override
    public String toString() {
        return "Producto [idProducto=" + ID_Producto + ", nombreProducto=" + NombreProducto + ", categoria=" + Categoria + 
                ", precioVenta=" + PrecioVenta + ", principioActivo=" + PrincipioActivo + ", presentacion=" + Presentacion + 
                ", laboratorio=" + Laboratorio + "]";
    }
}