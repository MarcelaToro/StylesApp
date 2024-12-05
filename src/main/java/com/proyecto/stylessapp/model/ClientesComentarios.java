package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CLIENTES_COMENTARIOS")
@IdClass(ClientesComentariosId.class)
public class ClientesComentarios {

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENTES_ID_CLIENTE", nullable = false)
    private Clientes cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMENTARIOS_ID_COMENTARIO", nullable = false)
    private Comentarios comentario;

    // Getters y Setters

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Comentarios getComentario() {
        return comentario;
    }

    public void setComentario(Comentarios comentario) {
        this.comentario = comentario;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesComentarios that = (ClientesComentarios) o;
        return Objects.equals(cliente, that.cliente) &&
                Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, comentario);
    }
}
