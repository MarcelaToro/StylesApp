package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.CitasClientesId;
import com.proyecto.stylessapp.model.CitasClientes;


import java.util.List;
import java.util.Optional;

public interface CitasClientesService {
    CitasClientes saveCitasClientes(CitasClientes citasClientes);
    Optional<CitasClientes> getCitasClientesById(CitasClientesId id);
    List<CitasClientes> getAllCitasClientes();
    CitasClientes updateCitasClientes(CitasClientes citasClientes);
    void deleteCitasClientes(CitasClientesId id);
}
