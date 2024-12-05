package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Servicios;

import java.util.List;
import java.util.Optional;

public interface ServiciosService {
    Servicios saveServicio(Servicios servicio);
    Optional<Servicios> getServicioById(Long id);
    List<Servicios> getAllServicios();
    Servicios updateServicio(Servicios servicio);
    void deleteServicio(Long id);
}
