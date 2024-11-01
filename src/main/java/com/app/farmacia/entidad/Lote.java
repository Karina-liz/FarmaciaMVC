package com.app.farmacia.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lotes")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Long idLote;

    @Column(name = "lote", nullable = false, length = 50)
    private String lote;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    public Lote() {
    }

    public Lote(Long idLote, String lote, String fechaVencimiento) {
        this.idLote = idLote;
        this.lote = lote;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Lote [idLote=" + idLote + ", lote=" + lote + ", fechaVencimiento=" + fechaVencimiento + "]";
    }
}