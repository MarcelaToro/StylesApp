
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
