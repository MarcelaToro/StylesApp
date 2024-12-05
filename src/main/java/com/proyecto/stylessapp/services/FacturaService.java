
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Factura;
import java.util.List;
import java.util.Optional;


public interface FacturaService {
    
    Factura saveFactura(Factura factura);
    
    Optional<Factura> getFacturaById(Long id);
    
    List<Factura> getAllFacturas();
    
    Factura updateFactura(Factura factura);
    
    void deleteFactura(Long id);
}
