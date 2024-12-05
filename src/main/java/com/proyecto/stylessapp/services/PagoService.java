
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Pago;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    
    Pago savePago(Pago pago);
    
    Optional<Pago> getPagoById(Long id);
    
    List<Pago> getAllPagos();
    
    Pago updatePago(Pago pago);
    
    void deletePago(Long id);
    
}
