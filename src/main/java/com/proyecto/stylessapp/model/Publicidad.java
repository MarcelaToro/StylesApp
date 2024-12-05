
package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PUBLICIDAD")
public class Publicidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publicidad_id_publicidad_seq")
    @SequenceGenerator(name = "publicidad_id_publicidad_seq", sequenceName = "publicidad_id_publicidad_seq", allocationSize = 1)
    @Column(name = "ID_PUBLICIDAD", nullable = false)
    private Long idPublicidad;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "COSTO", nullable = false)
    private Long costo;

    @Column(name = "FECHA_PUBLICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToOne
@JoinColumn(
    name = "PELUQUERIA_ID_PELUQUERIA", 
    referencedColumnName = "ID_PELUQUERIA",
    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
)
@JsonManagedReference
    private Peluqueria peluqueria;

    public Publicidad() {}

    public Publicidad(String descripcion, Long costo, Date fechaPublicacion, Peluqueria peluqueria) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaPublicacion = fechaPublicacion;
        this.peluqueria = peluqueria;
    }

    public Long getIdPublicidad() {
        return idPublicidad;
    }

    public void setIdPublicidad(Long idPublicidad) {
        this.idPublicidad = idPublicidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }
}
