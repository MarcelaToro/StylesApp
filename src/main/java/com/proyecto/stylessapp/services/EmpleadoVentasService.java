
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.EmpleadoVentas;
import com.proyecto.stylessapp.model.EmpleadoVentasPK;

import java.util.List;
import java.util.Optional;

public interface EmpleadoVentasService {

    EmpleadoVentas saveEmpleadoVentas(EmpleadoVentas empleadoVentas);

    Optional<EmpleadoVentas> getEmpleadoVentasById(EmpleadoVentasPK id);

    List<EmpleadoVentas> getAllEmpleadoVentas();

    EmpleadoVentas updateEmpleadoVentas(EmpleadoVentas empleadoVentas);

    void deleteEmpleadoVentas(EmpleadoVentasPK id);
}
