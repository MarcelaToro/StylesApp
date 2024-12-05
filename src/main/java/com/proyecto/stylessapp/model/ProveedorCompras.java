
package com.proyecto.stylessapp.model;

import jakarta.persistence.*;

@Entity
@Table
@IdClass(ProveedorComprasId.class)
public class ProveedorCompras {

    @Id
    @Column(name = "PROVEEDOR_ID_PROVEEDOR")
    private Long proveedorId;

    @Id
    @Column(name = "COMPRAS_ID_COMPRA")
    private Long compraId;

    @ManyToOne
    @JoinColumn(name = "PROVEEDOR_ID_PROVEEDOR", insertable = false, updatable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "COMPRAS_ID_COMPRA", insertable = false, updatable = false)
    private Compras compras;

    // Getters y setters
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }
}
