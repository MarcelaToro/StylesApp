package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Peluqueria;
import com.proyecto.stylessapp.services.PeluqueriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/peluqueria")
public class PeluqueriaController {

    @Autowired
    private PeluqueriaService peluqueriaService;

    // Muestra el formulario para agregar una nueva peluquería
    @GetMapping("/formularioPeluqueria")
    public String showRegistrationForm(Model model) {
        model.addAttribute("peluqueria", new Peluqueria());
        return "formularioPeluqueria";  // Thymeleaf: nombre de la vista HTML
    }

    // Agrega una peluquería a través del formulario
    @PostMapping("/registrar")
public String registrarPeluqueria(@RequestParam Long idPeluqueria,
                                  @RequestParam String nombre,
                                  @RequestParam String direccion,
                                  @RequestParam String telefono,
                                  @RequestParam String email,
                                  @RequestParam String horarioApertura,
                                  @RequestParam String horarioCierre,
                                  @RequestParam String fechaCreacion,
                                  @RequestParam String numeroEmpleados,
                                  @RequestParam String descripcion,
                                  @RequestParam String capacidadMaxima,
                                  @RequestParam String password,
                                  Model model) {

    try {
        // Formato para fechas y horas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Crear nueva peluquería
        Peluqueria peluqueria = new Peluqueria();
        peluqueria.setIdPeluqueria(idPeluqueria);  // Este es el campo que ingresará el usuario
        peluqueria.setNombre(nombre);
        peluqueria.setDireccion(direccion);
        peluqueria.setTelefono(Long.parseLong(telefono));
        peluqueria.setEmail(email);
        peluqueria.setHorarioApertura(timeFormat.parse(horarioApertura));
        peluqueria.setHorarioCierre(timeFormat.parse(horarioCierre));
        peluqueria.setFechaCreacion(dateFormat.parse(fechaCreacion));
        peluqueria.setNumeroEmpleados(Long.parseLong(numeroEmpleados));
        peluqueria.setDescripcion(descripcion);
        peluqueria.setCapacidadMaxima(Long.parseLong(capacidadMaxima));
        peluqueria.setPassword(password);

        // Guardar la peluquería a través del servicio
        peluqueriaService.savePeluqueria(peluqueria);

        return "redirect:/login"; // Redirige tras un registro exitoso
    } catch (Exception e) {
        model.addAttribute("error", "Error al registrar peluquería: " + e.getMessage());
        return "formularioPeluqueria";
    }
}

    

    // Método para generar un ID único para la peluquería (puedes cambiarlo a tu gusto)
    private Long generateUniqueIdPeluqueria() {
        return System.currentTimeMillis();  // Usa la hora actual como ID único
    }

    // Métodos REST existentes:
    @PostMapping
    public ResponseEntity<Peluqueria> createCliente(@RequestBody Peluqueria peluqueria) {
        Peluqueria savedPeluqueria = peluqueriaService.savePeluqueria(peluqueria);
        return ResponseEntity.ok(savedPeluqueria);
    }

    // Obtiene una peluquería por ID
    @GetMapping("/{peluqueriaId}")
    public ResponseEntity<Peluqueria> getPeluqueriaById(@PathVariable Long peluqueriaId) {
        Optional<Peluqueria> peluqueria = peluqueriaService.getPeluqueriaById(peluqueriaId);
        return peluqueria.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Peluqueria>> getAllPeluquerias() {
        List<Peluqueria> peluquerias = peluqueriaService.getAllPeluquerias();
        return ResponseEntity.ok(peluquerias);
    }

    @PutMapping("/{peluqueriaId}")
    public ResponseEntity<Peluqueria> updatePeluqueria(@PathVariable Long peluqueriaId, @RequestBody Peluqueria peluqueria) {
        peluqueria.setPeluqueriaId(peluqueriaId);
        Peluqueria updatedPeluqueria = peluqueriaService.updatePeluqueria(peluqueria);
        return ResponseEntity.ok(updatedPeluqueria);
    }

    @DeleteMapping("/{peluqueriaId}")
    public ResponseEntity<Void> deletePeluqueria(@PathVariable Long peluqueriaId) {
        peluqueriaService.deletePeluqueria(peluqueriaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Peluqueria> getPeluqueriaByEmail(@PathVariable String email) {
        Optional<Peluqueria> peluqueria = peluqueriaService.getPeluqueriaByEmail(email);
        return peluqueria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
