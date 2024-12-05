
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    
    List<Producto> getAllProductos();
    
    Optional<Producto> getProductoById(Long id);
    
    Producto saveProducto(Producto producto);
    
    void deleteProducto(Long id);
}
