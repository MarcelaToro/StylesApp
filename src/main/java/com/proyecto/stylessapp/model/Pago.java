
package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAGO")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGO", nullable = false)
    private Long idPago;
    
    @Column(name = "MONTO", nullable = false)
    private Long monto;
    
    @Column(name = "FECHA_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    
    // Constructor por defecto
    public Pago() {}

    // Constructor con parámetros
    public Pago(Long monto, Date fechaPago) {
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters
    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
