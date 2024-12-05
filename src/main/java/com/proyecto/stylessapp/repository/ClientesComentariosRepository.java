package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.ClientesComentarios;
import com.proyecto.stylessapp.model.ClientesComentariosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesComentariosRepository extends JpaRepository<ClientesComentarios, ClientesComentariosId> {
    
}
