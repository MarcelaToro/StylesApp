
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.ProveedorCompras;
import com.proyecto.stylessapp.model.ProveedorComprasId;
import com.proyecto.stylessapp.services.ProveedorComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedorcompras")
public class ProveedorComprasController {

    @Autowired
    private ProveedorComprasService proveedorComprasService;

    @GetMapping
    public List<ProveedorCompras> getAllProveedorCompras() {
        return proveedorComprasService.getAllProveedorCompras();
    }

    @GetMapping("/{proveedorId}/{compraId}")
    public ResponseEntity<ProveedorCompras> getProveedorComprasById(
            @PathVariable Long proveedorId, @PathVariable Long compraId) {
        ProveedorComprasId id = new ProveedorComprasId(proveedorId, compraId);
        Optional<ProveedorCompras> proveedorCompras = proveedorComprasService.getProveedorComprasById(id);
        return proveedorCompras.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProveedorCompras createProveedorCompras(@RequestBody ProveedorCompras proveedorCompras) {
        return proveedorComprasService.saveProveedorCompras(proveedorCompras);
    }

    @DeleteMapping("/{proveedorId}/{compraId}")
    public ResponseEntity<Void> deleteProveedorCompras(
            @PathVariable Long proveedorId, @PathVariable Long compraId) {
        ProveedorComprasId id = new ProveedorComprasId(proveedorId, compraId);
        proveedorComprasService.deleteProveedorCompras(id);
        return ResponseEntity.noContent().build();
    }
}
