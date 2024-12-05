
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Pago;
import com.proyecto.stylessapp.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago")
public class PagoController {
    
    @Autowired
    private PagoService pagoService;
    
    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        Pago savedPago = pagoService.savePago(pago);
        return ResponseEntity.ok(savedPago);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Optional<Pago> pago = pagoService.getPagoById(id);
        return pago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        List<Pago> pagos = pagoService.getAllPagos();
        return ResponseEntity.ok(pagos);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pago) {
        pago.setIdPago(id);
        Pago updatedPago = pagoService.updatePago(pago);
        return ResponseEntity.ok(updatedPago);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
