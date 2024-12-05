
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Reportes;
import com.proyecto.stylessapp.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @PostMapping
    public ResponseEntity<Reportes> createReportes(@RequestBody Reportes reportes) {
        Reportes savedReportes = reportesService.saveReportes(reportes);
        return ResponseEntity.ok(savedReportes);
    }

    @GetMapping("/{idReportes}")
    public ResponseEntity<Reportes> getReportesById(@PathVariable Long idReportes) {
        Optional<Reportes> reportes = reportesService.getReportesById(idReportes);
        return reportes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Reportes>> getAllReportes() {
        List<Reportes> reportes = reportesService.getAllReportes();
        return ResponseEntity.ok(reportes);
    }

    @PutMapping("/{idReportes}")
    public ResponseEntity<Reportes> updateReportes(@PathVariable Long idReportes, @RequestBody Reportes reportes) {
        reportes.setIdReportes(idReportes);
        Reportes updatedReportes = reportesService.updateReportes(reportes);
        return ResponseEntity.ok(updatedReportes);
    }

    @DeleteMapping("/{idReportes}")
    public ResponseEntity<Void> deleteReportes(@PathVariable Long idReportes) {
        reportesService.deleteReportes(idReportes);
        return ResponseEntity.noContent().build();
    }
}
