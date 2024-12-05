
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ProveedorCompras;
import com.proyecto.stylessapp.model.ProveedorComprasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorComprasRepository extends JpaRepository<ProveedorCompras, ProveedorComprasId>{
    
}
