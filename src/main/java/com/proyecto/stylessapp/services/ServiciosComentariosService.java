
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ServiciosComentarios;
import com.proyecto.stylessapp.model.ServiciosComentariosId;
import java.util.List;
import java.util.Optional;

public interface ServiciosComentariosService {
    
    ServiciosComentarios saveServiciosComentario(ServiciosComentarios serviciosComentario);
    
    Optional<ServiciosComentarios> getServiciosComentarioById(ServiciosComentariosId id);
    
    List<ServiciosComentarios> getAllServiciosComentario();
    
    ServiciosComentarios updateServiciosComentario(ServiciosComentarios serviciosComentario);
    
    void deleteServiciosComentario(ServiciosComentariosId id);
}
