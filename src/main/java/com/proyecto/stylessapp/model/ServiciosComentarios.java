
package com.proyecto.stylessapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "SERVICIOS_COMENTARIOS")
public class ServiciosComentarios {

    @EmbeddedId
    private ServiciosComentariosId id;

    // Constructor por defecto
    public ServiciosComentarios() {}

    // Constructor con parámetros
    public ServiciosComentarios(ServiciosComentariosId id) {
        this.id = id;
    }

    // Getters y Setters
    public ServiciosComentariosId getId() {
        return id;
    }

    public void setId(ServiciosComentariosId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosComentarios that = (ServiciosComentarios) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
