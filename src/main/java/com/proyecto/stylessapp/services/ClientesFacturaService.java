package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.ClientesFactura;
import com.proyecto.stylessapp.model.ClientesFacturaId;

import java.util.List;
import java.util.Optional;

public interface ClientesFacturaService {

    ClientesFactura saveClientesFactura(ClientesFactura clientesFactura);

    Optional<ClientesFactura> getClientesFacturaById(ClientesFacturaId id);

    List<ClientesFactura> getAllClientesFacturas();

    ClientesFactura updateClientesFactura(ClientesFactura clientesFactura);

    void deleteClientesFactura(ClientesFacturaId id);
}

