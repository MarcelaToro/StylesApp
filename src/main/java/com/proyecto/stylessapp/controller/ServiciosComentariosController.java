
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.ServiciosComentarios;
import com.proyecto.stylessapp.model.ServiciosComentariosId;

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
import com.proyecto.stylessapp.services.ServiciosComentariosService;

@RestController
@RequestMapping("/api/servicios-comentarios")
public class ServiciosComentariosController {
    
    @Autowired
    private ServiciosComentariosService serviciosComentarioService;
    
    @PostMapping
     public ResponseEntity<ServiciosComentarios> createServiciosComentario(@RequestBody ServiciosComentarios serviciosComentario) {
        ServiciosComentarios savedServiciosComentario = serviciosComentarioService.saveServiciosComentario(serviciosComentario);
        return ResponseEntity.ok(savedServiciosComentario);
    }
    
     @GetMapping("7{serviciosId}/{comentarioId}")
     public ResponseEntity<ServiciosComentarios> getServiciosComentarioById(
     @PathVariable Long serviciosId, @PathVariable long comentarioId) {
     
     ServiciosComentariosId id = new ServiciosComentariosId(serviciosId, comentarioId);
         Optional<ServiciosComentarios> servicioscomentario = serviciosComentarioService.getServiciosComentarioById(id);
         return servicioscomentario.map(ResponseEntity::ok) .orElseGet(() -> ResponseEntity.notFound().build());
     }
     
     @GetMapping
     public ResponseEntity<List<ServiciosComentarios>> getAllServiciosComentario() {
     List<ServiciosComentarios> serviciosComentarios = serviciosComentarioService.getAllServiciosComentario();
     return ResponseEntity.ok(serviciosComentarios);
     }
     
     @PutMapping
     public ResponseEntity<ServiciosComentarios> updateServiciosComentario(@RequestBody ServiciosComentarios serviciosComentario) {
     ServiciosComentarios updateServiciosComentario = serviciosComentarioService.updateServiciosComentario(serviciosComentario);
     return ResponseEntity.ok(updateServiciosComentario);
     }
     
      @DeleteMapping("/{serviciosId}/{comentarioId}")
    public ResponseEntity<Void> deleteServiciosComentario(
            @PathVariable Long serviciosId,
            @PathVariable Long comentarioId) {
        
        ServiciosComentariosId id = new ServiciosComentariosId(serviciosId, comentarioId);
        serviciosComentarioService.deleteServiciosComentario(id);
        return ResponseEntity.noContent().build();
     }
}
