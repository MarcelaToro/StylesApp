
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Compras;
import com.proyecto.stylessapp.services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @GetMapping
    public List<Compras> getAllCompras() {
        return comprasService.getAllCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compras> getComprasById(@PathVariable Long id) {
        Optional<Compras> compras = comprasService.getComprasById(id);
        return compras.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Compras createCompras(@RequestBody Compras compras) {
        return comprasService.saveCompras(compras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compras> updateCompras(@PathVariable Long id, @RequestBody Compras comprasDetails) {
        Optional<Compras> compras = comprasService.getComprasById(id);
        if (compras.isPresent()) {
            comprasDetails.setIdCompra(id); // Corregido el nombre del método
            return ResponseEntity.ok(comprasService.saveCompras(comprasDetails));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompras(@PathVariable Long id) {
        comprasService.deleteCompras(id);
        return ResponseEntity.noContent().build();
    }
}
