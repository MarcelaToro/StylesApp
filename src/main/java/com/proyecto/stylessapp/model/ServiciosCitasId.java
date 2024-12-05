
package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServiciosCitasId implements Serializable {

    @Column(name = "SERVICIOS_ID_SERVICIO")
    private Long serviciosIdServicio;

    @Column(name = "CITAS_ID_CITA")
    private Long citasIdCita;

    @Column(name = "CITAS_EMPLEADO_ID_EMPLEADO")
    private Long citasEmpleadoIdEmpleado;

    // Constructor por defecto
    public ServiciosCitasId() {}

    // Constructor con parámetros
    public ServiciosCitasId(Long serviciosIdServicio, Long citasIdCita, Long citasEmpleadoIdEmpleado) {
        this.serviciosIdServicio = serviciosIdServicio;
        this.citasIdCita = citasIdCita;
        this.citasEmpleadoIdEmpleado = citasEmpleadoIdEmpleado;
    }

    // Getters y Setters
    public Long getServiciosIdServicio() {
        return serviciosIdServicio;
    }

    public void setServiciosIdServicio(Long serviciosIdServicio) {
        this.serviciosIdServicio = serviciosIdServicio;
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
        ServiciosCitasId that = (ServiciosCitasId) o;
        return Objects.equals(serviciosIdServicio, that.serviciosIdServicio) &&
               Objects.equals(citasIdCita, that.citasIdCita) &&
               Objects.equals(citasEmpleadoIdEmpleado, that.citasEmpleadoIdEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviciosIdServicio, citasIdCita, citasEmpleadoIdEmpleado);
    }
}
