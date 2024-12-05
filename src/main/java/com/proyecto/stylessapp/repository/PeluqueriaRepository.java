
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.Peluqueria;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeluqueriaRepository extends JpaRepository<Peluqueria, Long>{
    Optional<Peluqueria> findByEmail(String email);
    Optional<Peluqueria> findByResetToken(String token);
}
