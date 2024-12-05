
package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ServiciosComentarios;
import com.proyecto.stylessapp.model.ServiciosComentariosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosComentariosRepository extends JpaRepository<ServiciosComentarios, ServiciosComentariosId>{
    
}
