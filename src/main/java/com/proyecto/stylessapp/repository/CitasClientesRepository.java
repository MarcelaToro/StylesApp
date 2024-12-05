package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.CitasClientesId;
import com.proyecto.stylessapp.model.CitasClientes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasClientesRepository extends JpaRepository<CitasClientes, CitasClientesId> {
    // Métodos personalizados si es necesario
}
