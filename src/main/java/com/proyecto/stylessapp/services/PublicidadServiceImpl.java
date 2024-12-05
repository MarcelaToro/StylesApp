package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Publicidad;
import com.proyecto.stylessapp.repository.PublicidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicidadServiceImpl implements PublicidadService {

    @Autowired
    private PublicidadRepository publicidadRepository;

    @Override
    public Publicidad savePublicidad(Publicidad publicidad) {
        return publicidadRepository.save(publicidad);
    }

    @Override
    public Optional<Publicidad> getPublicidadById(Long idPublicidad) {
        return publicidadRepository.findById(idPublicidad);
    }

    @Override
    public List<Publicidad> getAllPublicidad() {
        return publicidadRepository.findAll();
    }

    @Override
    public Publicidad updatePublicidad(Publicidad publicidad) {
        return publicidadRepository.save(publicidad);
    }

    @Override
    public void deletePublicidad(Long idPublicidad) {
        publicidadRepository.deleteById(idPublicidad);
    }
}
