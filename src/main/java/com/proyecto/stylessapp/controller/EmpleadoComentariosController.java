package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.EmpleadoComentarios;
import com.proyecto.stylessapp.model.EmpleadoComentariosId;
import com.proyecto.stylessapp.services.EmpleadoComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado-comentarios")
public class EmpleadoComentariosController {

    @Autowired
    private EmpleadoComentariosService empleadoComentariosService;

    @PostMapping
    public ResponseEntity<EmpleadoComentarios> createEmpleadoComentarios(@RequestBody EmpleadoComentarios empleadoComentarios) {
        EmpleadoComentarios savedEmpleadoComentarios = empleadoComentariosService.saveEmpleadoComentarios(empleadoComentarios);
        return ResponseEntity.ok(savedEmpleadoComentarios);
    }

    @GetMapping("/{empleadoId}/{comentarioId}")
    public ResponseEntity<EmpleadoComentarios> getEmpleadoComentariosById(
            @PathVariable Long empleadoId, @PathVariable Long comentarioId) {
        EmpleadoComentariosId id = new EmpleadoComentariosId(empleadoId, comentarioId);
        Optional<EmpleadoComentarios> empleadoComentarios = empleadoComentariosService.getEmpleadoComentariosById(id);
        return empleadoComentarios.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoComentarios>> getAllEmpleadoComentarios() {
        List<EmpleadoComentarios> empleadoComentarios = empleadoComentariosService.getAllEmpleadoComentarios();
        return ResponseEntity.ok(empleadoComentarios);
    }

    @PutMapping("/{empleadoId}/{comentarioId}")
    public ResponseEntity<EmpleadoComentarios> updateEmpleadoComentarios(
            @PathVariable Long empleadoId, @PathVariable Long comentarioId,
            @RequestBody EmpleadoComentarios empleadoComentarios) {
        EmpleadoComentariosId id = new EmpleadoComentariosId(empleadoId, comentarioId);
        empleadoComentarios.setId(id);
        EmpleadoComentarios updatedEmpleadoComentarios = empleadoComentariosService.updateEmpleadoComentarios(empleadoComentarios);
        return ResponseEntity.ok(updatedEmpleadoComentarios);
    }

    @DeleteMapping("/{empleadoId}/{comentarioId}")
    public ResponseEntity<Void> deleteEmpleadoComentarios(
            @PathVariable Long empleadoId, @PathVariable Long comentarioId) {
        EmpleadoComentariosId id = new EmpleadoComentariosId(empleadoId, comentarioId);
        empleadoComentariosService.deleteEmpleadoComentarios(id);
        return ResponseEntity.noContent().build();
    }
}
