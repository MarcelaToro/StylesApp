package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Publicidad;

import java.util.List;
import java.util.Optional;

public interface PublicidadService {

    Publicidad savePublicidad(Publicidad publicidad);

    Optional<Publicidad> getPublicidadById(Long idPublicidad);

    List<Publicidad> getAllPublicidad();

    Publicidad updatePublicidad(Publicidad publicidad);

    void deletePublicidad(Long idPublicidad);
}
