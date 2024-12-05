package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CITAS_CLIENTES")
public class CitasClientes {

    @EmbeddedId
    private CitasClientesId id;

    @ManyToOne
    @MapsId("citasIdCita")
    @JoinColumn(name = "CITAS_ID_CITA", nullable = false)
    @JsonBackReference
    private Citas cita;

    @ManyToOne
    @MapsId("citasEmpleadoIdEmpleado")
    @JoinColumn(name = "CITAS_EMPLEADO_ID_EMPLEADO", nullable = false)
    @JsonBackReference
    private Empleado empleado;

    @ManyToOne
    @MapsId("clientesIdCliente")
    @JoinColumn(name = "CLIENTES_ID_CLIENTE", nullable = false)
    @JsonBackReference
    private Clientes cliente;

    // Getters y Setters
    public CitasClientesId getId() {
        return id;
    }

    public void setId(CitasClientesId id) {
        this.id = id;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitasClientes that = (CitasClientes) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cita, that.cita) &&
                Objects.equals(empleado, that.empleado) &&
                Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cita, empleado, cliente);
    }
}
