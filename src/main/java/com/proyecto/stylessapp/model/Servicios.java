package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SERVICIOS")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICIO", nullable = false)
    private Long idServicio;

    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "PRECIO", length = 20)
    private String precio;

    @Column(name = "CATEGORIA", length = 100)
    private String categoria;

    @Column(name = "MATERIALES", length = 200)
    private String materiales;

    @Column(name = "EMPLEADOS_NECESARIOS")
    private Long empleadosNecesarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PELUQUERIA_ID_PELUQUERIA", nullable = false)
    private Peluqueria peluqueria;

    // Constructor por defecto
    public Servicios() {}

    // Constructor con parámetros
    public Servicios(Long idServicio, String nombre, String descripcion, String precio, String categoria, String materiales, Long empleadosNecesarios, Peluqueria peluqueria) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.materiales = materiales;
        this.empleadosNecesarios = empleadosNecesarios;
        this.peluqueria = peluqueria;
    }

    // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public Long getEmpleadosNecesarios() {
        return empleadosNecesarios;
    }

    public void setEmpleadosNecesarios(Long empleadosNecesarios) {
        this.empleadosNecesarios = empleadosNecesarios;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicios that = (Servicios) o;
        return Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio);
    }
}
