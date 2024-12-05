
package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VENTAS")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ventas_id_venta_seq")
    @SequenceGenerator(name = "ventas_id_venta_seq", sequenceName = "ventas_id_venta_seq", allocationSize = 1)
    @Column(name = "ID_VENTA", nullable = false)
    private Long idVenta;

    @Column(name = "FECHA_VENTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Column(name = "MONTO_TOTAL")
    private Long montoTotal;

    @ManyToOne
    @JoinColumn(name = "CLIENTES_ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "FACTURAS_ID_FACTURA", referencedColumnName = "ID_FACTURA", nullable = false)
    private Factura factura;

    // Constructor por defecto
    public Ventas() {}

    // Constructor con parámetros
    public Ventas(Date fechaVenta, Long montoTotal, Clientes cliente, Factura factura) {
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.cliente = cliente;
        this.factura = factura;
    }

    // Getters y Setters
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    // Constructor con ID_VENTA
    public Ventas(Long idVenta) {
        this.idVenta = idVenta;
    }
}
