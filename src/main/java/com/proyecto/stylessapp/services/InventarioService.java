
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Inventario;
import java.util.List;
import java.util.Optional;

public interface InventarioService {
    
    Inventario saveInventario(Inventario inventario);
    
    Optional<Inventario> getInventarioById(String nombre);
    
    List<Inventario> getAllInventarios();
    
    Inventario updateInventario(Inventario inventario);
    
    void deleteInventario(String nombre);
}
