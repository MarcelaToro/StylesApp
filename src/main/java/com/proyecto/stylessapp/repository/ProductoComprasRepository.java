
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ProductoCompras;
import com.proyecto.stylessapp.model.ProductoComprasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoComprasRepository extends JpaRepository<ProductoCompras, ProductoComprasId>{
    
}
