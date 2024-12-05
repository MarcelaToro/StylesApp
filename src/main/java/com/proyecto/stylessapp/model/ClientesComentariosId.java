package com.proyecto.stylessapp.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ClientesComentariosId implements Serializable {
    private Long cliente;
    private Long comentario;

    // Constructor por defecto
    public ClientesComentariosId() {}

    // Constructor con parámetros
    public ClientesComentariosId(Long cliente, Long comentario) {
        this.cliente = cliente;
        this.comentario = comentario;
    }

    // Getters y Setters
    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getComentario() {
        return comentario;
    }

    public void setComentario(Long comentario) {
        this.comentario = comentario;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesComentariosId that = (ClientesComentariosId) o;
        return Objects.equals(cliente, that.cliente) &&
               Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, comentario);
    }
}
