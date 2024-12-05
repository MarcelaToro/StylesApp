
package com.proyecto.stylessapp.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ProveedorComprasId implements Serializable{
    private Long proveedorId;
    private Long compraId;
    
public ProveedorComprasId() {
    }

    public ProveedorComprasId(Long proveedorId, Long compraId) {
        this.proveedorId = proveedorId;
        this.compraId = compraId;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
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
        ProveedorComprasId that = (ProveedorComprasId) o;
        return Objects.equals(proveedorId, that.proveedorId) && Objects.equals(compraId, that.compraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proveedorId, compraId);
    }
}
