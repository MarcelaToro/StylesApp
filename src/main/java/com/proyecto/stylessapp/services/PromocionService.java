package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Promocion;

import java.util.List;
import java.util.Optional;

public interface PromocionService {

    Promocion savePromocion(Promocion promocion);

    Optional<Promocion> getPromocionById(Long idPromocion);

    List<Promocion> getAllPromociones();

    Promocion updatePromocion(Promocion promocion);

    void deletePromocion(Long idPromocion);
}

