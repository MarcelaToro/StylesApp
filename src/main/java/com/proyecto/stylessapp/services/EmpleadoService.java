
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    
    Empleado saveEmpleado(Empleado empleado);
    
    Optional<Empleado> getEmpleadoById(Long id); // Cambiado a getEmpleadoById
    
    List<Empleado> getAllEmpleados();
    
    Empleado updateEmpleado(Empleado empleado);
    
    void deleteEmpleado(Long id);
}
