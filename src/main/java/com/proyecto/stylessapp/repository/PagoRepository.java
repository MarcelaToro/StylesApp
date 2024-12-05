
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
    
}
