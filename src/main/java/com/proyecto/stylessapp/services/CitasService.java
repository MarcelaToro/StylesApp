package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Citas;
import java.util.List;
import java.util.Optional;

public interface CitasService {
    Citas saveCita(Citas cita);
    Optional<Citas> getCitaById(Long id);
    List<Citas> getAllCitas();
    Citas updateCita(Citas cita);
    void deleteCita(Long id);
    // Métodos personalizados si es necesario
}
