package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Comentarios;

import java.util.List;
import java.util.Optional;

public interface ComentariosService {
    Comentarios saveComentario(Comentarios comentario);
    Optional<Comentarios> getComentarioById(Long id);
    List<Comentarios> getAllComentarios();
    Comentarios updateComentario(Comentarios comentario);
    void deleteComentario(Long id);
}
