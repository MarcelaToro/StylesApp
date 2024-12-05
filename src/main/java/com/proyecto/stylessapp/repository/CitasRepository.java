
package com.proyecto.stylessapp.repository;
import com.proyecto.stylessapp.model.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long>{
   
}
