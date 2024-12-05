package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoVentasPK implements Serializable {

    @Column(name = "EMPLEADO_ID_EMPLEADO")
    private Long empleadoIdEmpleado;

    @Column(name = "VENTAS_ID_VENTA")
    private Long ventasIdVenta;

    // Constructor por defecto
    public EmpleadoVentasPK() {}

    // Constructor con parámetros
    public EmpleadoVentasPK(Long empleadoIdEmpleado, Long ventasIdVenta) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoVentasPK that = (EmpleadoVentasPK) o;
        return Objects.equals(empleadoIdEmpleado, that.empleadoIdEmpleado) && Objects.equals(ventasIdVenta, that.ventasIdVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoIdEmpleado, ventasIdVenta);
    }
}

