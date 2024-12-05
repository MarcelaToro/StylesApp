
package com.proyecto.stylessapp.model;


import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductoComprasId implements Serializable{
    
    private Long productoId;
    private Long compraId;

    public ProductoComprasId() {
    }

    public ProductoComprasId(Long productoId, Long compraId) {
        this.productoId = productoId;
        this.compraId = compraId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoComprasId that = (ProductoComprasId) o;
        return Objects.equals(productoId, that.productoId) && Objects.equals(compraId, that.compraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, compraId);
    }
}