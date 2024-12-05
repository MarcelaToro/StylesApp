package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.repository.CitasRepository;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    private CitasRepository citaRepository;

    @Override
    public Citas saveCita(Citas cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Optional<Citas> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Citas> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Citas updateCita(Citas cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }

    // Métodos personalizados si es necesario
}

