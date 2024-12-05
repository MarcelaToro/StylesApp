
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ServiciosCitas;
import com.proyecto.stylessapp.model.ServiciosCitasId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.repository.ServiciosCitasRepository;

@Service
public class ServiciosCitasServiceImpl implements ServiciosCitasService {

    @Autowired
    private ServiciosCitasRepository serviciosCitaRepository;

    @Override
    public ServiciosCitas saveServiciosCita(ServiciosCitas serviciosCita) {
        return serviciosCitaRepository.save(serviciosCita);
    }

    @Override
    public Optional<ServiciosCitas> getServiciosCitaById(ServiciosCitasId id) {
        return serviciosCitaRepository.findById(id);
    }

    @Override
    public List<ServiciosCitas> getAllServiciosCita() {
        return serviciosCitaRepository.findAll();
    }

    @Override
    public ServiciosCitas updateServiciosCita(ServiciosCitas serviciosCita) {
        return serviciosCitaRepository.save(serviciosCita);
    }

    @Override
    public void deleteServiciosCita(ServiciosCitasId id) {
        serviciosCitaRepository.deleteById(id);
    }

  
}

