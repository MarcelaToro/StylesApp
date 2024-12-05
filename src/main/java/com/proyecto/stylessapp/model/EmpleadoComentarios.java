
package com.proyecto.stylessapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLEADO_COMENTARIOS")
public class EmpleadoComentarios implements Serializable {

    @EmbeddedId
    private EmpleadoComentariosId id;

    @ManyToOne
    @MapsId("empleadoIdEmpleado")
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @MapsId("comentariosIdComentario")
    @JoinColumn(name = "COMENTARIOS_ID_COMENTARIO", nullable = false)
    private Comentarios comentario;

    public EmpleadoComentarios() {}

    public EmpleadoComentarios(Empleado empleado, Comentarios comentario) {
        this.id = new EmpleadoComentariosId(empleado.getIdEmpleado(), comentario.getIdComentario());
        this.empleado = empleado;
        this.comentario = comentario;
    }

    // Getters y setters

    public EmpleadoComentariosId getId() {
        return id;
    }

    public void setId(EmpleadoComentariosId id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Comentarios getComentario() {
        return comentario;
    }

    public void setComentario(Comentarios comentario) {
        this.comentario = comentario;
    }
}
