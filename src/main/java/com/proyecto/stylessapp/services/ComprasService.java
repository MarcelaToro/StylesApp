
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Compras;
import java.util.List;
import java.util.Optional;

public interface ComprasService {
    List<Compras> getAllCompras();
    
    Optional<Compras> getComprasById(Long id);
    
    Compras saveCompras(Compras compras);
    
    void deleteCompras(Long id);
}
