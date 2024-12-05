package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.EmpleadoComentarios;
import com.proyecto.stylessapp.model.EmpleadoComentariosId;
import com.proyecto.stylessapp.repository.EmpleadoComentariosRepository;
import com.proyecto.stylessapp.services.EmpleadoComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoComentariosServiceImpl implements EmpleadoComentariosService {

    @Autowired
    private EmpleadoComentariosRepository empleadoComentariosRepository;

    @Override
    public EmpleadoComentarios saveEmpleadoComentarios(EmpleadoComentarios empleadoComentarios) {
        return empleadoComentariosRepository.save(empleadoComentarios);
    }

    @Override
    public Optional<EmpleadoComentarios> getEmpleadoComentariosById(EmpleadoComentariosId id) {
        return empleadoComentariosRepository.findById(id);
    }

    @Override
    public List<EmpleadoComentarios> getAllEmpleadoComentarios() {
        return empleadoComentariosRepository.findAll();
    }

    @Override
    public EmpleadoComentarios updateEmpleadoComentarios(EmpleadoComentarios empleadoComentarios) {
        return empleadoComentariosRepository.save(empleadoComentarios);
    }

    @Override
    public void deleteEmpleadoComentarios(EmpleadoComentariosId id) {
        empleadoComentariosRepository.deleteById(id);
    }
}

