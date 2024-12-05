
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, String> {
}
