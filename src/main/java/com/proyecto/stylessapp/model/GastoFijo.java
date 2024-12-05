package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GASTOS_FIJOS")
public class GastoFijo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GASTO", nullable = false)
    private Long idGasto;
    
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    
    @Column(name = "FECHA_GASTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaGasto;
    
    @Column(name = "MONTO", nullable = false)
    private Long monto;
    
    @ManyToOne
@JoinColumn(
    name = "PELUQUERIA_ID_PELUQUERIA", 
    referencedColumnName = "ID_PELUQUERIA",
    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
)
@JsonManagedReference // Indica que esta es la parte principal de la relación
 private Peluqueria peluqueria;
    
    // Constructor por defecto
    public GastoFijo() {}

    // Constructor con parámetros
    public GastoFijo(String descripcion, Date fechaGasto, Long monto, Peluqueria peluqueria) {
        this.descripcion = descripcion;
        this.fechaGasto = fechaGasto;
        this.monto = monto;
        this.peluqueria = peluqueria;
    }

    // Getters y Setters

    public Long getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Long idGasto) {
        this.idGasto = idGasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }
}
