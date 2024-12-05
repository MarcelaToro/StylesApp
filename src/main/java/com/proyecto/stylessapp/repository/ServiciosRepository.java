
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
    
}
