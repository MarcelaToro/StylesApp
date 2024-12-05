
package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PagoCitasId implements Serializable {
    
    @Column(name = "PAGO_ID_PAGO", nullable = false)
    private Long pagoIDPago;
    
    @Column(name = "CITAS_ID_CITA", nullable = false)
    private Long citasIdCita;
    
    @Column(name = "CITAS_EMPLEADO_ID_EMPLEADO", nullable = false)
    private Long citasEmpleadoIdEmpleado;
    
    // Constructor por defecto
    public PagoCitasId() {}

    // Constructor con parámetros
    public PagoCitasId(Long pagoIDPago, Long citasIdCita, Long citasEmpleadoIdEmpleado) {
        this.pagoIDPago = pagoIDPago;
        this.citasIdCita = citasIdCita;
        this.citasEmpleadoIdEmpleado = citasEmpleadoIdEmpleado;
    }

    // Getters y Setters
    public Long getPagoIDPago() {
        return pagoIDPago;
    }

    public void setPagoIDPago(Long pagoIDPago) {
        this.pagoIDPago = pagoIDPago;
    }

    public Long getCitasIdCita() {
        return citasIdCita;
    }

    public void setCitasIdCita(Long citasIdCita) {
        this.citasIdCita = citasIdCita;
    }

    public Long getCitasEmpleadoIdEmpleado() {
        return citasEmpleadoIdEmpleado;
    }

    public void setCitasEmpleadoIdEmpleado(Long citasEmpleadoIdEmpleado) {
        this.citasEmpleadoIdEmpleado = citasEmpleadoIdEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoCitasId that = (PagoCitasId) o;
        return Objects.equals(pagoIDPago, that.pagoIDPago) &&
                Objects.equals(citasIdCita, that.citasIdCita) &&
                Objects.equals(citasEmpleadoIdEmpleado, that.citasEmpleadoIdEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagoIDPago, citasIdCita, citasEmpleadoIdEmpleado);
    }
}
