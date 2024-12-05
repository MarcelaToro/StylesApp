package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Promocion;
import com.proyecto.stylessapp.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @PostMapping
    public ResponseEntity<Promocion> createPromocion(@RequestBody Promocion promocion) {
        Promocion savedPromocion = promocionService.savePromocion(promocion);
        return ResponseEntity.ok(savedPromocion);
    }

    @GetMapping("/{idPromocion}")
    public ResponseEntity<Promocion> getPromocionById(@PathVariable Long idPromocion) {
        Optional<Promocion> promocion = promocionService.getPromocionById(idPromocion);
        return promocion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Promocion>> getAllPromociones() {
        List<Promocion> promociones = promocionService.getAllPromociones();
        return ResponseEntity.ok(promociones);
    }

    @PutMapping("/{idPromocion}")
    public ResponseEntity<Promocion> updatePromocion(@PathVariable Long idPromocion, @RequestBody Promocion promocion) {
        promocion.setIdPromocion(idPromocion);
        Promocion updatedPromocion = promocionService.updatePromocion(promocion);
        return ResponseEntity.ok(updatedPromocion);
    }

    @DeleteMapping("/{idPromocion}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long idPromocion) {
        promocionService.deletePromocion(idPromocion);
        return ResponseEntity.noContent().build();
    }
}
