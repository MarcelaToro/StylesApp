package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROMOCIONES")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promociones_id_promocion_seq")
    @SequenceGenerator(name = "promociones_id_promocion_seq", sequenceName = "promociones_id_promocion_seq", allocationSize = 1)
    @Column(name = "ID_PROMOCION", nullable = false)
    private Long idPromocion;

    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;

    @Column(name = "DESCUENTO", nullable = false)
    private Long descuento;

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @ManyToOne
@JoinColumn(
    name = "PELUQUERIA_ID_PELUQUERIA", 
    referencedColumnName = "ID_PELUQUERIA",
    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
)
@JsonManagedReference
    private Peluqueria peluqueria;

    public Promocion() {}

    public Promocion(String descripcion, Long descuento, Date fechaInicio, Date fechaFin, Peluqueria peluqueria) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.peluqueria = peluqueria;
    }

    public Long getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }
}
