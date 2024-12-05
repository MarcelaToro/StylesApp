
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ServiciosCitas;
import com.proyecto.stylessapp.model.ServiciosCitasId;
import java.util.List;
import java.util.Optional;


public interface ServiciosCitasService {
    ServiciosCitas saveServiciosCita(ServiciosCitas serviciosCita);
    
    Optional<ServiciosCitas> getServiciosCitaById(ServiciosCitasId id);
    
    List<ServiciosCitas> getAllServiciosCita();
    
    ServiciosCitas updateServiciosCita(ServiciosCitas serviciosCita);
    
    void deleteServiciosCita(ServiciosCitasId id);
}
