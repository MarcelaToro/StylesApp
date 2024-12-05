
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.GastoFijo;
import java.util.List;
import java.util.Optional;

public interface GastoFijoService {
    
    GastoFijo saveGastoFijo(GastoFijo gastoFijo);
    
    Optional<GastoFijo> getGastoFijoById(Long id);
    
    List<GastoFijo> getAllGastosFijos();
    
    GastoFijo updateGastoFijo(GastoFijo gastoFijo);
    
    void deleteGastoFijo(Long id);
}
