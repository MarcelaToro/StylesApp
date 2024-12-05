package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Empleado;
import com.proyecto.stylessapp.model.EmpleadoVentas;
import com.proyecto.stylessapp.model.EmpleadoVentasPK;
import com.proyecto.stylessapp.model.Ventas;
import com.proyecto.stylessapp.services.EmpleadoVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado-ventas")
public class EmpleadoVentasController {

    @Autowired
    private EmpleadoVentasService empleadoVentasService;

    @PostMapping
    public ResponseEntity<EmpleadoVentas> createEmpleadoVentas(@RequestBody EmpleadoVentas empleadoVentas) {
        EmpleadoVentas savedEmpleadoVentas = empleadoVentasService.saveEmpleadoVentas(empleadoVentas);
        return ResponseEntity.ok(savedEmpleadoVentas);
    }

    @GetMapping("/{empleadoIdEmpleado}/{ventasIdVenta}")
    public ResponseEntity<EmpleadoVentas> getEmpleadoVentasById(@PathVariable Long empleadoIdEmpleado, @PathVariable Long ventasIdVenta) {
        EmpleadoVentasPK id = new EmpleadoVentasPK(empleadoIdEmpleado, ventasIdVenta);
        Optional<EmpleadoVentas> empleadoVentas = empleadoVentasService.getEmpleadoVentasById(id);
        return empleadoVentas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoVentas>> getAllEmpleadoVentas() {
        List<EmpleadoVentas> empleadoVentas = empleadoVentasService.getAllEmpleadoVentas();
        return ResponseEntity.ok(empleadoVentas);
    }

    @PutMapping("/{empleadoIdEmpleado}/{ventasIdVenta}")
    public ResponseEntity<EmpleadoVentas> updateEmpleadoVentas(@PathVariable Long empleadoIdEmpleado, @PathVariable Long ventasIdVenta, @RequestBody EmpleadoVentas empleadoVentas) {
        EmpleadoVentasPK id = new EmpleadoVentasPK(empleadoIdEmpleado, ventasIdVenta);
        empleadoVentas.setEmpleado(new Empleado(empleadoIdEmpleado)); // Necesario si se actualiza
        empleadoVentas.setVentas(new Ventas(ventasIdVenta)); // Necesario si se actualiza
        EmpleadoVentas updatedEmpleadoVentas = empleadoVentasService.updateEmpleadoVentas(empleadoVentas);
        return ResponseEntity.ok(updatedEmpleadoVentas);
    }

    @DeleteMapping("/{empleadoIdEmpleado}/{ventasIdVenta}")
    public ResponseEntity<Void> deleteEmpleadoVentas(@PathVariable Long empleadoIdEmpleado, @PathVariable Long ventasIdVenta) {
        EmpleadoVentasPK id = new EmpleadoVentasPK(empleadoIdEmpleado, ventasIdVenta);
        empleadoVentasService.deleteEmpleadoVentas(id);
        return ResponseEntity.noContent().build();
    }
}
