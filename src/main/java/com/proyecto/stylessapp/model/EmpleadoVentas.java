
package com.proyecto.stylessapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLEADO_VENTAS")
@IdClass(EmpleadoVentasPK.class)
public class EmpleadoVentas {

    @Id
    @Column(name = "EMPLEADO_ID_EMPLEADO")
    private Long empleadoIdEmpleado;

    @Id
    @Column(name = "VENTAS_ID_VENTA")
    private Long ventasIdVenta;

    @ManyToOne
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", insertable = false, updatable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "VENTAS_ID_VENTA", insertable = false, updatable = false)
    private Ventas ventas;

    // Constructor por defecto
    public EmpleadoVentas() {}

    // Constructor con parámetros
    public EmpleadoVentas(Long empleadoIdEmpleado, Long ventasIdVenta) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
        this.ventasIdVenta = ventasIdVenta;
    }

    // Getters y Setters
    public Long getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Long empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Long getVentasIdVenta() {
        return ventasIdVenta;
    }

    public void setVentasIdVenta(Long ventasIdVenta) {
        this.ventasIdVenta = ventasIdVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}
