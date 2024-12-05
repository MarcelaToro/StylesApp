
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long>{
    
}
