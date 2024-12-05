package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import com.proyecto.stylessapp.services.ClientesService;

@Controller  // Usamos @Controller porque manejaremos vistas HTML
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clienteService;

    // Método para mostrar el formulario de registro
    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "registro";  // La plantilla Thymeleaf para el formulario de registro
    }

    // Método para manejar el registro del cliente
    @PostMapping("/registrar")
    public String registrarCliente(@RequestParam String nombre,
                                   @RequestParam String apellido,
                                   @RequestParam String telefono,
                                   @RequestParam String email,
                                   @RequestParam String fechaNacimiento,
                                   @RequestParam String genero,
                                   @RequestParam String password) {
        Clientes cliente = new Clientes();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(Long.parseLong(telefono));
        cliente.setEmail(email);
        cliente.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));  // Asegura que la fecha tenga el formato correcto
        cliente.setGenero(genero);
        cliente.setPassword(password);

        // Guardar el cliente en la base de datos
        clienteService.saveCliente(cliente);

        return "redirect:/login";  // Redirigir a la página de login después del registro
    }

    // Métodos REST que ya tenías (no hay cambios):

    @PostMapping
    public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente) {
        Clientes savedCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteById(@PathVariable Long id) {
        Optional<Clientes> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> getAllClientes() {
        List<Clientes> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        cliente.setIdCliente(id);
        Clientes updatedCliente = clienteService.updateCliente(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Clientes> getClienteByEmail(@PathVariable String email) {
        Optional<Clientes> cliente = clienteService.getClienteByEmail(email);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
