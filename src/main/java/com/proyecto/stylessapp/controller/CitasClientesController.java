package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.CitasClientesId;
import com.proyecto.stylessapp.model.CitasClientes;
import com.proyecto.stylessapp.services.CitasClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas-clientes")
public class CitasClientesController {

    @Autowired
    private CitasClientesService citasClientesService;

    @PostMapping
    public ResponseEntity<CitasClientes> createCitasClientes(@RequestBody CitasClientes citasClientes) {
        CitasClientes savedCitasClientes = citasClientesService.saveCitasClientes(citasClientes);
        return ResponseEntity.ok(savedCitasClientes);
    }

    @GetMapping("/{citaId}/{empleadoId}/{clienteId}")
    public ResponseEntity<CitasClientes> getCitasClientesById(
            @PathVariable Long citaId, @PathVariable Long empleadoId, @PathVariable Long clienteId) {
        CitasClientesId id = new CitasClientesId(citaId, empleadoId, clienteId);
        Optional<CitasClientes> citasClientes = citasClientesService.getCitasClientesById(id);
        return citasClientes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CitasClientes>> getAllCitasClientes() {
        List<CitasClientes> citasClientes = citasClientesService.getAllCitasClientes();
        return ResponseEntity.ok(citasClientes);
    }

    @PutMapping("/{citaId}/{empleadoId}/{clienteId}")
    public ResponseEntity<CitasClientes> updateCitasClientes(
            @PathVariable Long citaId, @PathVariable Long empleadoId, @PathVariable Long clienteId,
            @RequestBody CitasClientes citasClientes) {
        CitasClientesId id = new CitasClientesId(citaId, empleadoId, clienteId);
        citasClientes.setId(id);
        CitasClientes updatedCitasClientes = citasClientesService.updateCitasClientes(citasClientes);
        return ResponseEntity.ok(updatedCitasClientes);
    }

    @DeleteMapping("/{citaId}/{empleadoId}/{clienteId}")
    public ResponseEntity<Void> deleteCitasClientes(
            @PathVariable Long citaId, @PathVariable Long empleadoId, @PathVariable Long clienteId) {
        CitasClientesId id = new CitasClientesId(citaId, empleadoId, clienteId);
        citasClientesService.deleteCitasClientes(id);
        return ResponseEntity.noContent().build();
    }
}
