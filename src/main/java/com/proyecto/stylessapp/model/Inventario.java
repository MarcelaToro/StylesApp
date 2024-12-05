
package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    
    @Id
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "DECRIPCION", length = 200)
    private String descripcion;
    
    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private Long precioUnitario;
    
    @Column(name = "CANTIDAD_STOCK", nullable = false)
    private Long cantidadStock;
    
    @Column(name = "PROVEEDOR", nullable = false, length = 100)
    private String proveedor;
    
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "CATEGORIA", nullable = false, length = 50)
    private String categoria;
    
    @Column(name = "UBICACION", nullable = false, length = 50)
    private String ubicacion;
    
    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @ManyToOne
    @JoinColumn(
    name = "PELUQUERIA_ID_PELUQUERIA", 
    referencedColumnName = "ID_PELUQUERIA",
    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    @JsonManagedReference
    private Peluqueria peluqueria;
    
    public Inventario() {}

    public Inventario(String nombre, String descripcion, Long precioUnitario, Long cantidadStock, String proveedor, Date fechaIngreso, String categoria, String ubicacion, Date fechaVencimiento, Peluqueria peluqueria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidadStock = cantidadStock;
        this.proveedor = proveedor;
        this.fechaIngreso = fechaIngreso;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fechaVencimiento = fechaVencimiento;
        this.peluqueria = peluqueria;
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

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Long cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Peluqueria getPeluqueria() {
        return peluqueria;
    }

    public void setPeluqueria(Peluqueria peluqueria) {
        this.peluqueria = peluqueria;
    }
    
    
    
}
