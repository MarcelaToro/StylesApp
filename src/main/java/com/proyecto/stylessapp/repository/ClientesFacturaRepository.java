
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ClientesFactura;
import com.proyecto.stylessapp.model.ClientesFacturaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesFacturaRepository extends JpaRepository<ClientesFactura, ClientesFacturaId> {
    
}
