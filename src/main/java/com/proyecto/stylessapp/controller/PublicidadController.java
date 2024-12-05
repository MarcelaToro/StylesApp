
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Publicidad;
import com.proyecto.stylessapp.services.PublicidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publicidad")
public class PublicidadController {

    @Autowired
    private PublicidadService publicidadService;

    @PostMapping
    public ResponseEntity<Publicidad> createPublicidad(@RequestBody Publicidad publicidad) {
        Publicidad savedPublicidad = publicidadService.savePublicidad(publicidad);
        return ResponseEntity.ok(savedPublicidad);
    }

    @GetMapping("/{idPublicidad}")
    public ResponseEntity<Publicidad> getPublicidadById(@PathVariable Long idPublicidad) {
        Optional<Publicidad> publicidad = publicidadService.getPublicidadById(idPublicidad);
        return publicidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Publicidad>> getAllPublicidad() {
        List<Publicidad> publicidad = publicidadService.getAllPublicidad();
        return ResponseEntity.ok(publicidad);
    }

    @PutMapping("/{idPublicidad}")
    public ResponseEntity<Publicidad> updatePublicidad(@PathVariable Long idPublicidad, @RequestBody Publicidad publicidad) {
        publicidad.setIdPublicidad(idPublicidad);
        Publicidad updatedPublicidad = publicidadService.updatePublicidad(publicidad);
        return ResponseEntity.ok(updatedPublicidad);
    }

    @DeleteMapping("/{idPublicidad}")
    public ResponseEntity<Void> deletePublicidad(@PathVariable Long idPublicidad) {
        publicidadService.deletePublicidad(idPublicidad);
        return ResponseEntity.noContent().build();
    }
}

