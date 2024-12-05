
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.PagoCitas;
import com.proyecto.stylessapp.model.PagoCitasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoCitasRepository extends JpaRepository<PagoCitas, PagoCitasId>{
    
}
