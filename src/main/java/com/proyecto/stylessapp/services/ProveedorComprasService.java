
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ProveedorCompras;
import com.proyecto.stylessapp.model.ProveedorComprasId;
import java.util.List;
import java.util.Optional;

public interface ProveedorComprasService {
    
    List<ProveedorCompras> getAllProveedorCompras();
    
    Optional<ProveedorCompras> getProveedorComprasById(ProveedorComprasId id);
    
    ProveedorCompras saveProveedorCompras(ProveedorCompras proveedorCompras);
    
    void deleteProveedorCompras(ProveedorComprasId id);
}
