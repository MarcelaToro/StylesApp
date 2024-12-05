package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.services.ServiciosService;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService servicioService;

    @PostMapping
    public ResponseEntity<Servicios> createServicio(@RequestBody Servicios servicio) {
        Servicios savedServicio = servicioService.saveServicio(servicio);
        return ResponseEntity.ok(savedServicio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicios> getServicioById(@PathVariable Long id) {
        Optional<Servicios> servicio = servicioService.getServicioById(id);
        return servicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Servicios>> getAllServicios() {
        List<Servicios> servicios = servicioService.getAllServicios();
        return ResponseEntity.ok(servicios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicios> updateServicio(@PathVariable Long id, @RequestBody Servicios servicio) {
        servicio.setIdServicio(id);
        Servicios updatedServicio = servicioService.updateServicio(servicio);
        return ResponseEntity.ok(updatedServicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        servicioService.deleteServicio(id);
        return ResponseEntity.noContent().build();
    }
}
