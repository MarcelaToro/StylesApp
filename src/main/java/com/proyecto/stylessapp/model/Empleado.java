package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO", nullable = false)
    private Long idEmpleado;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "TELEFONO", nullable = false)
    private Long telefono;

    @Column(name = "ESPECIALIDAD")
    private String especialidad;

    @Column(name = "PELUQUERIA_ID_PELUQUERIA")
    private Long peluqueriaIdPeluqueria;

    // Constructor por defecto
    public Empleado() {}

    // Constructor adicional con ID_EMPLEADO
    public Empleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    // Constructor completo
    public Empleado(String nombre, String apellido, String email, Long telefono, String especialidad, Long peluqueriaIdPeluqueria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.peluqueriaIdPeluqueria = peluqueriaIdPeluqueria;
    }

    // Getters y setters

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getPeluqueriaIdPeluqueria() {
        return peluqueriaIdPeluqueria;
    }

    public void setPeluqueriaIdPeluqueria(Long peluqueriaIdPeluqueria) {
        this.peluqueriaIdPeluqueria = peluqueriaIdPeluqueria;
    }

    // Métodos equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(idEmpleado, empleado.idEmpleado) &&
               Objects.equals(nombre, empleado.nombre) &&
               Objects.equals(apellido, empleado.apellido) &&
               Objects.equals(email, empleado.email) &&
               Objects.equals(telefono, empleado.telefono) &&
               Objects.equals(especialidad, empleado.especialidad) &&
               Objects.equals(peluqueriaIdPeluqueria, empleado.peluqueriaIdPeluqueria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, nombre, apellido, email, telefono, especialidad, peluqueriaIdPeluqueria);
    }
}

