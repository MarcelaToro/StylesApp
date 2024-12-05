package com.proyecto.stylessapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PELUQUERIA")
public class Peluqueria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peluqueria_peluqueria_id_seq")
    @SequenceGenerator(name = "peluqueria_peluqueria_id_seq", sequenceName = "peluqueria_peluqueria_id_seq", allocationSize = 1)
    @Column(name = "PELUQUERIA_ID", nullable = false)
    private Long peluqueriaId; // Este campo será autogenerado por la secuencia

    @Column(name = "ID_PELUQUERIA", nullable = false, unique = true)
    private Long idPeluqueria;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 70)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false)
    private Long telefono;

    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "HORARIO_APERTURA")
    @Temporal(TemporalType.TIME)
    private Date horarioApertura;

    @Column(name = "HORARIO_CIERRE")
    @Temporal(TemporalType.TIME)
    private Date horarioCierre;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "NUMERO_EMPLEADOS", nullable = false)
    private Long numeroEmpleados;

    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @Column(name = "CAPACIDAD_MAXIMA", nullable = false)
    private Long capacidadMaxima;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name = "RESET_TOKEN")
    private String resetToken;

    @Column(name = "TOKEN_EXPIRY_DATE")
    private Date tokenExpiryDate;

    @OneToMany(mappedBy = "peluqueria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "peluqueria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GastoFijo> gastosFijos;

    // Constructor vacío
    public Peluqueria() {}

    // Getters y Setters
    public Long getPeluqueriaId() {
        return peluqueriaId;
    }

    public void setPeluqueriaId(Long peluqueriaId) {
        this.peluqueriaId = peluqueriaId;
    }

    public Long getIdPeluqueria() {
        return idPeluqueria;
    }

    public void setIdPeluqueria(Long idPeluqueria) {
        this.idPeluqueria = idPeluqueria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(Date horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public Date getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(Date horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Long numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Long capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Date getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    public void setTokenExpiryDate(Date tokenExpiryDate) {
        this.tokenExpiryDate = tokenExpiryDate;
    }
}
