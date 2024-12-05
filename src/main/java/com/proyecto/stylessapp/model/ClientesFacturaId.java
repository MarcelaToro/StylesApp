package com.proyecto.stylessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientesFacturaId implements Serializable {

    @Column(name = "CLIENTES_ID_CLIENTE", nullable = false) // Corregido el nombre de columna
    private Long clientesIdCliente;

    @Column(name = "FACTURAS_ID_FACTURA", nullable = false) // Corregido el nombre de columna
    private Long facturasIdFactura;

    // Constructor por defecto
    public ClientesFacturaId() {}

    // Constructor con parámetros
    public ClientesFacturaId(Long clientesIdCliente, Long facturasIdFactura) {
        this.clientesIdCliente = clientesIdCliente;
        this.facturasIdFactura = facturasIdFactura;
    }

    // Getters y Setters
    public Long getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Long clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public Long getFacturasIdFactura() {
        return facturasIdFactura;
    }

    public void setFacturasIdFactura(Long facturasIdFactura) {
        this.facturasIdFactura = facturasIdFactura;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesFacturaId that = (ClientesFacturaId) o;
        return Objects.equals(clientesIdCliente, that.clientesIdCliente) &&
               Objects.equals(facturasIdFactura, that.facturasIdFactura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientesIdCliente, facturasIdFactura);
    }
}
