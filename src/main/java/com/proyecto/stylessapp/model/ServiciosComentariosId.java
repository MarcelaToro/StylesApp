
package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServiciosComentariosId implements Serializable {

    @Column(name = "SERVICIOS_ID_SERVICIO")
    private Long serviciosIdServicio;

    @Column(name = "COMENTARIO_ID_COMENTARIO")
    private Long comentarioIdComentario;

    // Constructor por defecto
    public ServiciosComentariosId() {}

    // Constructor con parámetros
    public ServiciosComentariosId(Long serviciosIdServicio, Long comentarioIdComentario) {
        this.serviciosIdServicio = serviciosIdServicio;
        this.comentarioIdComentario = comentarioIdComentario;
    }

    // Getters y Setters
    public Long getServiciosIdServicio() {
        return serviciosIdServicio;
    }

    public void setServiciosIdServicio(Long serviciosIdServicio) {
        this.serviciosIdServicio = serviciosIdServicio;
    }

    public Long getComentarioIdComentario() {
        return comentarioIdComentario;
    }

    public void setComentarioIdComentario(Long comentarioIdComentario) {
        this.comentarioIdComentario = comentarioIdComentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosComentariosId that = (ServiciosComentariosId) o;
        return Objects.equals(serviciosIdServicio, that.serviciosIdServicio) &&
               Objects.equals(comentarioIdComentario, that.comentarioIdComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviciosIdServicio, comentarioIdComentario);
    }
}
