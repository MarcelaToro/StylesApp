
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.PagoCitas;
import com.proyecto.stylessapp.model.PagoCitasId;
import java.util.List;
import java.util.Optional;

public interface PagoCitasService {
    
    PagoCitas savePagoCitas(PagoCitas pagoCitas);
    
    Optional<PagoCitas> getPagoCitasById(PagoCitasId id);
    
    List<PagoCitas> getAllPagosCitas();
    
    PagoCitas updatePagoCitas(PagoCitas pagoCitas);
    
    void deletePagoCitas(PagoCitasId id);
}
