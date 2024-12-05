
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ServiciosCitas;
import com.proyecto.stylessapp.model.ServiciosCitasId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiciosCitasRepository extends JpaRepository<ServiciosCitas, ServiciosCitasId> {
    
}
