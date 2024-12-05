package com.proyecto.stylessapp.repository;

import com.proyecto.stylessapp.model.EmpleadoVentas;
import com.proyecto.stylessapp.model.EmpleadoVentasPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoVentasRepository extends JpaRepository<EmpleadoVentas, EmpleadoVentasPK> {
}
