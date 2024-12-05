
package com.proyecto.stylessapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES_FACTURA")
public class ClientesFactura {
    
    @EmbeddedId
    private ClientesFacturaId id;
    
    public ClientesFactura() {}
    
    public ClientesFactura(ClientesFacturaId id) {
    this.id = id;
    }

    public ClientesFacturaId getId() {
        return id;
    }

    public void setId(ClientesFacturaId id) {
        this.id = id;
    }
    
    
}
