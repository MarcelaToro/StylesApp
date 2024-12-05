package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.CitasClientesId;
import com.proyecto.stylessapp.model.CitasClientes;

import com.proyecto.stylessapp.repository.CitasClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasClientesServiceImpl implements CitasClientesService {

    @Autowired
    private CitasClientesRepository citasClientesRepository;

    @Override
    public CitasClientes saveCitasClientes(CitasClientes citasClientes) {
        return citasClientesRepository.save(citasClientes);
    }

    @Override
    public Optional<CitasClientes> getCitasClientesById(CitasClientesId id) {
        return citasClientesRepository.findById(id);
    }

    @Override
    public List<CitasClientes> getAllCitasClientes() {
        return citasClientesRepository.findAll();
    }

    @Override
    public CitasClientes updateCitasClientes(CitasClientes citasClientes) {
        return citasClientesRepository.save(citasClientes);
    }

    @Override
    public void deleteCitasClientes(CitasClientesId id) {
        citasClientesRepository.deleteById(id);
    }
}
