
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.ProductoCompras;
import com.proyecto.stylessapp.model.ProductoComprasId;
import com.proyecto.stylessapp.services.ProductoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productocompras")
public class ProductoComprasController {

    @Autowired
    private ProductoComprasService productoComprasService;

    @GetMapping
    public List<ProductoCompras> getAllProductoCompras() {
        return productoComprasService.getAllProductoCompras();
    }

    @GetMapping("/{productoId}/{compraId}")
    public ResponseEntity<ProductoCompras> getProductoComprasById(
            @PathVariable Long productoId, @PathVariable Long compraId) {
        ProductoComprasId id = new ProductoComprasId(productoId, compraId);
        Optional<ProductoCompras> productoCompras = productoComprasService.getProductoComprasById(id);
        return productoCompras.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductoCompras createProductoCompras(@RequestBody ProductoCompras productoCompras) {
        return productoComprasService.saveProductoCompras(productoCompras);
    }

    @DeleteMapping("/{productoId}/{compraId}")
    public ResponseEntity<Void> deleteProductoCompras(
            @PathVariable Long productoId, @PathVariable Long compraId) {
        ProductoComprasId id = new ProductoComprasId(productoId, compraId);
        productoComprasService.deleteProductoCompras(id);
        return ResponseEntity.noContent().build();
    }
}
