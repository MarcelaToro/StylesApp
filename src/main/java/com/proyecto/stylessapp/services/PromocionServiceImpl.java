package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Promocion;
import com.proyecto.stylessapp.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    @Override
    public Promocion savePromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    @Override
    public Optional<Promocion> getPromocionById(Long idPromocion) {
        return promocionRepository.findById(idPromocion);
    }

    @Override
    public List<Promocion> getAllPromociones() {
        return promocionRepository.findAll();
    }

    @Override
    public Promocion updatePromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    @Override
    public void deletePromocion(Long idPromocion) {
        promocionRepository.deleteById(idPromocion);
    }
}

