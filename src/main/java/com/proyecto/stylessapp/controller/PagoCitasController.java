
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.PagoCitas;
import com.proyecto.stylessapp.model.PagoCitasId;
import com.proyecto.stylessapp.services.PagoCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago-citas")
public class PagoCitasController {
    
    @Autowired
    private PagoCitasService pagoCitasService;
    
    @PostMapping
    public ResponseEntity<PagoCitas> createPagoCitas(@RequestBody PagoCitas pagoCitas) {
        PagoCitas savedPagoCitas = pagoCitasService.savePagoCitas(pagoCitas);
        return ResponseEntity.ok(savedPagoCitas);
    }
    
    @GetMapping("/{pagoId}/{citaId}/{empleadoId}")
    public ResponseEntity<PagoCitas> getPagoCitasById(@PathVariable Long pagoId, @PathVariable Long citaId, @PathVariable Long empleadoId) {
        PagoCitasId id = new PagoCitasId(pagoId, citaId, empleadoId);
        Optional<PagoCitas> pagoCitas = pagoCitasService.getPagoCitasById(id);
        return pagoCitas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<PagoCitas>> getAllPagosCitas() {
        List<PagoCitas> pagoCitas = pagoCitasService.getAllPagosCitas();
        return ResponseEntity.ok(pagoCitas);
    }
    
    @PutMapping("/{pagoId}/{citaId}/{empleadoId}")
    public ResponseEntity<PagoCitas> updatePagoCitas(@PathVariable Long pagoId, @PathVariable Long citaId, @PathVariable Long empleadoId, @RequestBody PagoCitas pagoCitas) {
        PagoCitasId id = new PagoCitasId(pagoId, citaId, empleadoId);
        pagoCitas.setId(id);
        PagoCitas updatedPagoCitas = pagoCitasService.updatePagoCitas(pagoCitas);
        return ResponseEntity.ok(updatedPagoCitas);
    }
    
    @DeleteMapping("/{pagoId}/{citaId}/{empleadoId}")
    public ResponseEntity<Void> deletePagoCitas(@PathVariable Long pagoId, @PathVariable Long citaId, @PathVariable Long empleadoId) {
        PagoCitasId id = new PagoCitasId(pagoId, citaId, empleadoId);
        pagoCitasService.deletePagoCitas(id);
        return ResponseEntity.noContent().build();
    }
}
