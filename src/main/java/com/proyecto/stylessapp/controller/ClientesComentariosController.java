package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Clientes;
import com.proyecto.stylessapp.model.ClientesComentarios;
import com.proyecto.stylessapp.model.ClientesComentariosId;
import com.proyecto.stylessapp.model.Comentarios;
import com.proyecto.stylessapp.services.ClientesComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes-comentarios")
public class ClientesComentariosController {

    @Autowired
    private ClientesComentariosService clientesComentariosService;

    @PostMapping
    public ResponseEntity<ClientesComentarios> createClientesComentarios(@RequestBody ClientesComentarios clientesComentarios) {
        ClientesComentarios savedClientesComentarios = clientesComentariosService.saveClientesComentarios(clientesComentarios);
        return ResponseEntity.ok(savedClientesComentarios);
    }

    @GetMapping("/{clienteId}/{comentarioId}")
    public ResponseEntity<ClientesComentarios> getClientesComentariosById(
            @PathVariable Long clienteId, @PathVariable Long comentarioId) {
        ClientesComentariosId id = new ClientesComentariosId(clienteId, comentarioId);
        Optional<ClientesComentarios> clientesComentarios = clientesComentariosService.getClientesComentariosById(id);
        return clientesComentarios.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClientesComentarios>> getAllClientesComentarios() {
        List<ClientesComentarios> clientesComentariosList = clientesComentariosService.getAllClientesComentarios();
        return ResponseEntity.ok(clientesComentariosList);
    }

    @PutMapping("/{clienteId}/{comentarioId}")
    public ResponseEntity<ClientesComentarios> updateClientesComentarios(
            @PathVariable Long clienteId, @PathVariable Long comentarioId,
            @RequestBody ClientesComentarios clientesComentarios) {

        // Consultar los objetos existentes desde el servicio
        Optional<Clientes> clienteOpt = clientesComentariosService.getClienteById(clienteId);
        Optional<Comentarios> comentarioOpt = clientesComentariosService.getComentarioById(comentarioId);

        if (clienteOpt.isEmpty() || comentarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Establecer las entidades existentes en el objeto de actualización
        Clientes cliente = clienteOpt.get();
        Comentarios comentario = comentarioOpt.get();
        
        clientesComentarios.setCliente(cliente);
        clientesComentarios.setComentario(comentario);
        
        // Actualizar el objeto ClientesComentarios
        ClientesComentarios updatedClientesComentarios = clientesComentariosService.updateClientesComentarios(clientesComentarios);
        return ResponseEntity.ok(updatedClientesComentarios);
    }

    @DeleteMapping("/{clienteId}/{comentarioId}")
    public ResponseEntity<Void> deleteClientesComentarios(
            @PathVariable Long clienteId, @PathVariable Long comentarioId) {
        ClientesComentariosId id = new ClientesComentariosId(clienteId, comentarioId);
        clientesComentariosService.deleteClientesComentarios(id);
        return ResponseEntity.noContent().build();
    }
}

    
