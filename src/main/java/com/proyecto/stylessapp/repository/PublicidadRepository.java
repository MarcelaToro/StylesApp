
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Publicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicidadRepository extends JpaRepository<Publicidad, Long> {
}
