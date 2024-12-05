
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Reportes;
import com.proyecto.stylessapp.repository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportesServiceImpl implements ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    @Override
    public Reportes saveReportes(Reportes reportes) {
        return reportesRepository.save(reportes);
    }

    @Override
    public Optional<Reportes> getReportesById(Long idReportes) {
        return reportesRepository.findById(idReportes);
    }

    @Override
    public List<Reportes> getAllReportes() {
        return reportesRepository.findAll();
    }

    @Override
    public Reportes updateReportes(Reportes reportes) {
        return reportesRepository.save(reportes);
    }

    @Override
    public void deleteReportes(Long idReportes) {
        reportesRepository.deleteById(idReportes);
    }
}
