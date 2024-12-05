package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.repository.ComentariosRepository;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosRepository comentarioRepository;

    @Override
    public Comentarios saveComentario(Comentarios comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Optional<Comentarios> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public List<Comentarios> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentarios updateComentario(Comentarios comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}

