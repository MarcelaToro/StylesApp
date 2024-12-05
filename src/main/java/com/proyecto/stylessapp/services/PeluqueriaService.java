package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Peluqueria;

import java.util.List;
import java.util.Optional;

public interface PeluqueriaService {

    Peluqueria savePeluqueria(Peluqueria peluqueria);

    Optional<Peluqueria> getPeluqueriaById(Long peluqueriaId);

    List<Peluqueria> getAllPeluquerias();

    Peluqueria updatePeluqueria(Peluqueria peluqueria);

    void deletePeluqueria(Long peluqueriaId);
    
    Optional<Peluqueria> getPeluqueriaByEmail(String email);
    
    Optional<Peluqueria> findByResetToken(String token);
}
