
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.EmpleadoComentarios;
import com.proyecto.stylessapp.model.EmpleadoComentariosId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoComentariosRepository extends JpaRepository <EmpleadoComentarios, EmpleadoComentariosId>{
    
}
