
package com.proyecto.stylessapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTO_COMPRAS")
@IdClass(ProductoComprasId.class)
public class ProductoCompras {
    
    @Id 
    @Column(name = "PRODUCTO_ID_PRODUCTO")
    private Long productoId;
    
    @Id
    @Column(name = "COMPRAS_ID_COMPRA")
    private Long compraId;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTO_ID_PRODUCTO", insertable = false, updatable = false)
    @JsonBackReference
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "COMPRAS_ID_COMPRA", insertable = false, updatable = false)
    private Compras compras;

    // Getters y Setters
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }
}

