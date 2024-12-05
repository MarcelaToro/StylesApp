
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ServiciosComentarios;
import com.proyecto.stylessapp.model.ServiciosComentariosId;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.stylessapp.repository.ServiciosComentariosRepository;

@Service
public class ServiciosComentariosServiceImpl implements ServiciosComentariosService {
    
    @Autowired
    private ServiciosComentariosRepository serviciosComentarioRepository;
    
    @Override
    public ServiciosComentarios saveServiciosComentario(ServiciosComentarios serviciosComentario){
         return serviciosComentarioRepository.save(serviciosComentario);
    }

    @Override
    public Optional<ServiciosComentarios> getServiciosComentarioById(ServiciosComentariosId id) {
        return serviciosComentarioRepository.findById(id);
    }
    
    @Override
    public List<ServiciosComentarios> getAllServiciosComentario() {
        return serviciosComentarioRepository.findAll();
    }
    
    @Override
    public ServiciosComentarios updateServiciosComentario(ServiciosComentarios serviciosComentario) {
       return serviciosComentarioRepository.save(serviciosComentario);
    }
    @Override
    public void deleteServiciosComentario(ServiciosComentariosId id) {
         serviciosComentarioRepository.deleteById(id);
    }
}   

    