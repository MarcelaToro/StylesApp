
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.ServiciosCitas;
import com.proyecto.stylessapp.model.ServiciosCitasId;
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
import com.proyecto.stylessapp.services.ServiciosCitasService;

@RestController
@RequestMapping("/servicios-cita")
public class ServiciosCitasController {
    
    @Autowired
    private ServiciosCitasService serviciosCitaService;
    
    @PostMapping
    public ResponseEntity<ServiciosCitas> createServiciosCita(@RequestBody ServiciosCitas serviciosCita) {
    ServiciosCitas savedServiciosCita = serviciosCitaService.saveServiciosCita(serviciosCita);
    return ResponseEntity.ok(savedServiciosCita);
    }
    
    @GetMapping("/{servicioId}/{citaId}/{empleadoId}")
    public ResponseEntity<ServiciosCitas> getServicioCitaById(
            @PathVariable Long servicioId, @PathVariable Long citaId,
            @PathVariable Long empleadoId) {
    ServiciosCitasId id= new ServiciosCitasId(servicioId, citaId, empleadoId);
    Optional<ServiciosCitas> serviciosCita = serviciosCitaService.getServiciosCitaById(id);
    return serviciosCita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<ServiciosCitas>> getAllServiciosCita() {
    List<ServiciosCitas> serviciosCita = serviciosCitaService.getAllServiciosCita();
    return ResponseEntity.ok(serviciosCita);
    }
    
    @PutMapping("/{servicioId}/{citaId}/{empleadoId}")
    public ResponseEntity<ServiciosCitas> updateServiciosCita(
    @PathVariable Long servicioId, @PathVariable Long citaId, @PathVariable Long empleadoId,
            @RequestBody ServiciosCitas serviciosCita) {
    ServiciosCitasId id = new ServiciosCitasId(servicioId, citaId, empleadoId);
    serviciosCita.setId(id);
    ServiciosCitas updatedServiciosCita = serviciosCitaService.updateServiciosCita(serviciosCita);
    return ResponseEntity.ok(updatedServiciosCita);
    }
    
        @DeleteMapping("/{servicioId}/{citaId}/{empleadoId}")
    public ResponseEntity<Void> deleteServiciosCita(
            @PathVariable Long servicioId, @PathVariable Long citaId, @PathVariable Long empleadoId) {
        ServiciosCitasId id = new ServiciosCitasId(servicioId, citaId, empleadoId);
        serviciosCitaService.deleteServiciosCita(id);
        return ResponseEntity.noContent().build();
    }
}
