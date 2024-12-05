
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Reportes;

import java.util.List;
import java.util.Optional;

public interface ReportesService {

    Reportes saveReportes(Reportes reportes);

    Optional<Reportes> getReportesById(Long idReportes);

    List<Reportes> getAllReportes();

    Reportes updateReportes(Reportes reportes);

    void deleteReportes(Long idReportes);
}
