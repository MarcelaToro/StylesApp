package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "COMENTARIOS")
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO", nullable = false)
    private Long idComentario;

    @Column(name = "CONTENIDO", nullable = false)
    private String contenido;

    public Comentarios() {}

    public Comentarios(String contenido) {
        this.contenido = contenido;
    }

    // Getters y setters

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentarios that = (Comentarios) o;
        return Objects.equals(idComentario, that.idComentario) &&
               Objects.equals(contenido, that.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComentario, contenido);
    }
}


