package com.proyecto.stylessapp.model;
        
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


@Entity
@Table(name = "FACTURA")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FACTURA", nullable = false)
    private Long idFactura;
    
    @Column(name = "FECHA_EMISION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    
    @Column(name = "MONTO_TOTAL", nullable = false)
    private Long montoTotal;
    
    @Column(name = "ESTADO_PAGO")
    private String estadoPago;
    
    public Factura() {}
    
    public Factura(Date fechaEmision, Long montoTotal, String estadoPago) {
    this.fechaEmision = fechaEmision;
    this.montoTotal = montoTotal;
    this.estadoPago = estadoPago;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
    
}