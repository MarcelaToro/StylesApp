
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.GastoFijo;
import com.proyecto.stylessapp.services.GastoFijoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos-fijos")
public class GastoFijoController {
    
    @Autowired
    private GastoFijoService gastoFijoService;
    
    @PostMapping
    public ResponseEntity<GastoFijo> createGastoFijo(@RequestBody GastoFijo gastoFijo) {
    GastoFijo savedGastoFijo = gastoFijoService.saveGastoFijo(gastoFijo);
    return ResponseEntity.ok(savedGastoFijo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GastoFijo> getGastoFijoById(@PathVariable Long id) {
        Optional<GastoFijo> gastoFijo = gastoFijoService.getGastoFijoById(id);
         return gastoFijo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
     @GetMapping
    public ResponseEntity<List<GastoFijo>> getAllGastosFijos() {
        List<GastoFijo> gastosFijos = gastoFijoService.getAllGastosFijos();
        return ResponseEntity.ok(gastosFijos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoFijo> updateGastoFijo(@PathVariable Long id, @RequestBody GastoFijo gastoFijo) {
        gastoFijo.setIdGasto(id);
        GastoFijo updatedGastoFijo = gastoFijoService.updateGastoFijo(gastoFijo);
        return ResponseEntity.ok(updatedGastoFijo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGastoFijo(@PathVariable Long id) {
        gastoFijoService.deleteGastoFijo(id);
        return ResponseEntity.noContent().build();
    }
}
