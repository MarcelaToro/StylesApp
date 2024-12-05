
package com.proyecto.stylessapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGO_CITAS")
public class PagoCitas {
    
    @EmbeddedId
    private PagoCitasId id;
    
    // Constructor por defecto
    public PagoCitas() {}

    // Constructor con parámetros
    public PagoCitas(PagoCitasId id) {
        this.id = id;
    }

    // Getters y Setters
    public PagoCitasId getId() {
        return id;
    }

    public void setId(PagoCitasId id) {
        this.id = id;
    }
}
