package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ClientesFactura;
import com.proyecto.stylessapp.model.ClientesFacturaId;
import com.proyecto.stylessapp.repository.ClientesFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesFacturaServiceImpl implements ClientesFacturaService {

    @Autowired
    private ClientesFacturaRepository clientesFacturaRepository;

    @Override
    public ClientesFactura saveClientesFactura(ClientesFactura clientesFactura) {
        return clientesFacturaRepository.save(clientesFactura);
    }

    @Override
    public Optional<ClientesFactura> getClientesFacturaById(ClientesFacturaId id) {
        return clientesFacturaRepository.findById(id);
    }

    @Override
    public List<ClientesFactura> getAllClientesFacturas() {
        return clientesFacturaRepository.findAll();
    }

    @Override
    public ClientesFactura updateClientesFactura(ClientesFactura clientesFactura) {
        return clientesFacturaRepository.save(clientesFactura);
    }

    @Override
    public void deleteClientesFactura(ClientesFacturaId id) {
        clientesFacturaRepository.deleteById(id);
    }
}
