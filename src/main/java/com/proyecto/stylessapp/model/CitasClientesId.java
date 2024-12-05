package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CitasClientesId implements Serializable {

    @Column(name = "CITAS_ID_CITA", nullable = false)
    private Long citasIdCita;

    @Column(name = "CITAS_EMPLEADO_ID_EMPLEADO", nullable = false)
    private Long citasEmpleadoIdEmpleado;

    @Column(name = "CLIENTES_ID_CLIENTE", nullable = false)
    private Long clientesIdCliente;

    // Constructor por defecto
    public CitasClientesId() {}

    // Constructor con parámetros
    public CitasClientesId(Long citasIdCita, Long citasEmpleadoIdEmpleado, Long clientesIdCliente) {
        this.citasIdCita = citasIdCita;
        this.citasEmpleadoIdEmpleado = citasEmpleadoIdEmpleado;
        this.clientesIdCliente = clientesIdCliente;
    }

    // Getters y Setters
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

    public Long getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Long clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitasClientesId that = (CitasClientesId) o;
        return Objects.equals(citasIdCita, that.citasIdCita) &&
                Objects.equals(citasEmpleadoIdEmpleado, that.citasEmpleadoIdEmpleado) &&
                Objects.equals(clientesIdCliente, that.clientesIdCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citasIdCita, citasEmpleadoIdEmpleado, clientesIdCliente);
    }
}

