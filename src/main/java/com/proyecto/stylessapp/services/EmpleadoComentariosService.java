
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.EmpleadoComentarios;
import com.proyecto.stylessapp.model.EmpleadoComentariosId;

import java.util.List;
import java.util.Optional;

public interface EmpleadoComentariosService {

    EmpleadoComentarios saveEmpleadoComentarios(EmpleadoComentarios empleadoComentarios);

    Optional<EmpleadoComentarios> getEmpleadoComentariosById(EmpleadoComentariosId id);

    List<EmpleadoComentarios> getAllEmpleadoComentarios();

    EmpleadoComentarios updateEmpleadoComentarios(EmpleadoComentarios empleadoComentarios);

    void deleteEmpleadoComentarios(EmpleadoComentariosId id);
}
