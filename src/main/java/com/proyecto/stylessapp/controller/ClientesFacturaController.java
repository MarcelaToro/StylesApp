package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.ClientesFactura;
import com.proyecto.stylessapp.model.ClientesFacturaId;
import com.proyecto.stylessapp.services.ClientesFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes-facturas")
public class ClientesFacturaController {

    @Autowired
    private ClientesFacturaService clientesFacturaService;

    @PostMapping
    public ResponseEntity<ClientesFactura> createClientesFactura(@RequestBody ClientesFactura clientesFactura) {
        ClientesFactura savedClientesFactura = clientesFacturaService.saveClientesFactura(clientesFactura);
        return ResponseEntity.ok(savedClientesFactura);
    }

    @GetMapping("/{clienteId}/{facturaId}")
    public ResponseEntity<ClientesFactura> getClientesFacturaById(
            @PathVariable Long clienteId, @PathVariable Long facturaId) {
        ClientesFacturaId id = new ClientesFacturaId(clienteId, facturaId);
        Optional<ClientesFactura> clientesFactura = clientesFacturaService.getClientesFacturaById(id);
        return clientesFactura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClientesFactura>> getAllClientesFacturas() {
        List<ClientesFactura> clientesFacturas = clientesFacturaService.getAllClientesFacturas();
        return ResponseEntity.ok(clientesFacturas);
    }

    @PutMapping("/{clienteId}/{facturaId}")
    public ResponseEntity<ClientesFactura> updateClientesFactura(
            @PathVariable Long clienteId, @PathVariable Long facturaId, @RequestBody ClientesFactura clientesFactura) {
        ClientesFacturaId id = new ClientesFacturaId(clienteId, facturaId);
        clientesFactura.setId(id);
        ClientesFactura updatedClientesFactura = clientesFacturaService.updateClientesFactura(clientesFactura);
        return ResponseEntity.ok(updatedClientesFactura);
    }

    @DeleteMapping("/{clienteId}/{facturaId}")
    public ResponseEntity<Void> deleteClientesFactura(
            @PathVariable Long clienteId, @PathVariable Long facturaId) {
        ClientesFacturaId id = new ClientesFacturaId(clienteId, facturaId);
        clientesFacturaService.deleteClientesFactura(id);
        return ResponseEntity.noContent().build();
    }
}
