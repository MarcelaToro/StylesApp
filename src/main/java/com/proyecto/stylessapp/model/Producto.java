
package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;
    
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "FECHA_SALIDA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @OneToMany(mappedBy = "producto")
    @JsonManagedReference
    private List<ProductoCompras> productoCompras;

    // Getters y Setters
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<ProductoCompras> getProductoCompras() {
        return productoCompras;
    }

    public void setProductoCompras(List<ProductoCompras> productoCompras) {
        this.productoCompras = productoCompras;
    }
}
