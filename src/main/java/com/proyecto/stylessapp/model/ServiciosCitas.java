package com.proyecto.stylessapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "SERVICIOS_CITAS")
public class ServiciosCitas {

    @EmbeddedId
    private ServiciosCitasId id;

    // Constructor por defecto
    public ServiciosCitas() {}

    // Constructor con parámetros
    public ServiciosCitas(ServiciosCitasId id) {
        this.id = id;
    }

    // Getters y Setters
    public ServiciosCitasId getId() {
        return id;
    }

    public void setId(ServiciosCitasId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosCitas that = (ServiciosCitas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
