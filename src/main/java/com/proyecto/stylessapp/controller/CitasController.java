package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.services.CitasService;

@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService citaService;

    @PostMapping
    public ResponseEntity<Citas> createCita(@RequestBody Citas cita) {
        Citas savedCita = citaService.saveCita(cita);
        return ResponseEntity.ok(savedCita);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citas> getCitaById(@PathVariable Long id) {
        Optional<Citas> cita = citaService.getCitaById(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Citas>> getAllCitas() {
        List<Citas> citas = citaService.getAllCitas();
        return ResponseEntity.ok(citas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Citas> updateCita(@PathVariable Long id, @RequestBody Citas cita) {
        cita.setIdCita(id);
        Citas updatedCita = citaService.updateCita(cita);
        return ResponseEntity.ok(updatedCita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }
}
