
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ProductoCompras;
import com.proyecto.stylessapp.model.ProductoComprasId;
import java.util.List;
import java.util.Optional;

public interface ProductoComprasService {
    
    List<ProductoCompras> getAllProductoCompras();
    
    Optional<ProductoCompras> getProductoComprasById(ProductoComprasId id);
    
    ProductoCompras saveProductoCompras(ProductoCompras productoCompras);
    
    void deleteProductoCompras(ProductoComprasId id);
}
