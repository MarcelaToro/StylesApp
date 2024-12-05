
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Proveedor;
import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    
    List<Proveedor> getAllProveedores();
    
    Optional<Proveedor> getProveedorById(Long id);
    
    Proveedor saveProveedor(Proveedor proveedor);
    
    void deleteProveedor(Long id);
}
