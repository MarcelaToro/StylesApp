
package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoComentariosId implements Serializable {

    @Column(name = "EMPLEADO_ID_EMPLEADO", nullable = false)
    private Long empleadoIdEmpleado;

    @Column(name = "COMENTARIOS_ID_COMENTARIO", nullable = false)
    private Long comentariosIdComentario;

    public EmpleadoComentariosId() {}

    public EmpleadoComentariosId(Long empleadoIdEmpleado, Long comentariosIdComentario) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
        this.comentariosIdComentario = comentariosIdComentario;
    }

    // Getters y setters

    public Long getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Long empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Long getComentariosIdComentario() {
        return comentariosIdComentario;
    }

    public void setComentariosIdComentario(Long comentariosIdComentario) {
        this.comentariosIdComentario = comentariosIdComentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoComentariosId that = (EmpleadoComentariosId) o;
        return Objects.equals(empleadoIdEmpleado, that.empleadoIdEmpleado) &&
               Objects.equals(comentariosIdComentario, that.comentariosIdComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoIdEmpleado, comentariosIdComentario);
    }
}
