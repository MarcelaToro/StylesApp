
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Ventas;
import com.proyecto.stylessapp.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping
    public ResponseEntity<Ventas> createVentas(@RequestBody Ventas ventas) {
        Ventas savedVentas = ventasService.saveVentas(ventas);
        return ResponseEntity.ok(savedVentas);
    }

    @GetMapping("/{idVenta}")
    public ResponseEntity<Ventas> getVentasById(@PathVariable Long idVenta) {
        Optional<Ventas> ventas = ventasService.getVentasById(idVenta);
        return ventas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Ventas>> getAllVentas() {
        List<Ventas> ventas = ventasService.getAllVentas();
        return ResponseEntity.ok(ventas);
    }

    @PutMapping("/{idVenta}")
    public ResponseEntity<Ventas> updateVentas(@PathVariable Long idVenta, @RequestBody Ventas ventas) {
        ventas.setIdVenta(idVenta);
        Ventas updatedVentas = ventasService.updateVentas(ventas);
        return ResponseEntity.ok(updatedVentas);
    }

    @DeleteMapping("/{idVenta}")
    public ResponseEntity<Void> deleteVentas(@PathVariable Long idVenta) {
        ventasService.deleteVentas(idVenta);
        return ResponseEntity.noContent().build();
    }
}
