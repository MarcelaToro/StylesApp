package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.repository.ServiciosRepository;

@Service
public class ServiciosServiceImpl implements ServiciosService {

    @Autowired
    private ServiciosRepository servicioRepository;

    @Override
    public Servicios saveServicio(Servicios servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Optional<Servicios> getServicioById(Long id) {
        return servicioRepository.findById(id);
    }

    @Override
    public List<Servicios> getAllServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicios updateServicio(Servicios servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
