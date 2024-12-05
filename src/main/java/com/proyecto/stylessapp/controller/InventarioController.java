
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Inventario;
import com.proyecto.stylessapp.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<Inventario> createInventario(@RequestBody Inventario inventario) {
        Inventario savedInventario = inventarioService.saveInventario(inventario);
        return ResponseEntity.ok(savedInventario);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable String nombre) {
        Optional<Inventario> inventario = inventarioService.getInventarioById(nombre);
        return inventario.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventarios() {
        List<Inventario> inventarios = inventarioService.getAllInventarios();
        return ResponseEntity.ok(inventarios);
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable String nombre, @RequestBody Inventario inventario) {
        inventario.setNombre(nombre);
        Inventario updatedInventario = inventarioService.updateInventario(inventario);
        return ResponseEntity.ok(updatedInventario);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deleteInventario(@PathVariable String nombre) {
        inventarioService.deleteInventario(nombre);
        return ResponseEntity.noContent().build();
    }
}
