package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.services.ComentariosService;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentarioService;

    @PostMapping
    public ResponseEntity<Comentarios> createComentario(@RequestBody Comentarios comentario) {
        Comentarios savedComentario = comentarioService.saveComentario(comentario);
        return ResponseEntity.ok(savedComentario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentarios> getComentarioById(@PathVariable Long id) {
        Optional<Comentarios> comentario = comentarioService.getComentarioById(id);
        return comentario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Comentarios>> getAllComentarios() {
        List<Comentarios> comentarios = comentarioService.getAllComentarios();
        return ResponseEntity.ok(comentarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentarios> updateComentario(@PathVariable Long id, @RequestBody Comentarios comentario) {
        comentario.setIdComentario(id);
        Comentarios updatedComentario = comentarioService.updateComentario(comentario);
        return ResponseEntity.ok(updatedComentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
        return ResponseEntity.noContent().build();
    }
}
