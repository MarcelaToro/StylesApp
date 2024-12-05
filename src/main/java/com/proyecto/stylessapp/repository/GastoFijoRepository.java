
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.GastoFijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoFijoRepository extends JpaRepository<GastoFijo, Long> {
    
}
