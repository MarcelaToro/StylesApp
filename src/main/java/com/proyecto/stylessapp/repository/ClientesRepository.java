package com.proyecto.stylessapp.repository;


import com.proyecto.stylessapp.model.Clientes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    
    Optional<Clientes> findByEmail(String email);
    Optional<Clientes> findByResetToken(String token);
}

