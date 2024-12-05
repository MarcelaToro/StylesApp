
package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REPORTES")
public class Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportes_id_reportes_seq")
    @SequenceGenerator(name = "reportes_id_reportes_seq", sequenceName = "reportes_id_reportes_seq", allocationSize = 1)
    @Column(name = "ID_REPORTES", nullable = false)
    private Long idReportes;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "FECHA_GENERACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaGeneracion;

    @ManyToOne
@JoinColumn(
    name = "PELUQUERIA_ID_PELUQUERIA", 
    referencedColumnName = "ID_PELUQUERIA",
    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
)
@JsonManagedReference
    private Peluqueria peluqueria;

    // Constructor por defecto
    public Reportes() {}

    // Constructor con parámetros
    public Reportes(String descripcion, Date fechaGeneracion, Peluqueria peluqueria) {
        this.descripcion = descripcion;
        this.fechaGeneracion = fechaGeneracion;
        this.peluqueria = peluqueria;
    }

    // Getters y Setters
    public Long getIdReportes() {
        return idReportes;
    }

    public void setIdReportes(Long idReportes) {
        this.idReportes = idReportes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }
}
