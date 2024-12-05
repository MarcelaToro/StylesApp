package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Clientes;
import com.proyecto.stylessapp.model.Comentarios;
import com.proyecto.stylessapp.model.ClientesComentarios;
import com.proyecto.stylessapp.model.ClientesComentariosId;
import com.proyecto.stylessapp.repository.ClientesComentariosRepository;
import com.proyecto.stylessapp.repository.ClientesRepository;
import com.proyecto.stylessapp.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesComentariosServiceImpl implements ClientesComentariosService {

    @Autowired
    private ClientesComentariosRepository clientesComentariosRepository;
    
    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Override
    public ClientesComentarios saveClientesComentarios(ClientesComentarios clientesComentarios) {
        return clientesComentariosRepository.save(clientesComentarios);
    }

    @Override
    public Optional<ClientesComentarios> getClientesComentariosById(ClientesComentariosId id) {
        return clientesComentariosRepository.findById(id);
    }

    @Override
    public List<ClientesComentarios> getAllClientesComentarios() {
        return clientesComentariosRepository.findAll();
    }

    @Override
    public ClientesComentarios updateClientesComentarios(ClientesComentarios clientesComentarios) {
        return clientesComentariosRepository.save(clientesComentarios);
    }

    @Override
    public void deleteClientesComentarios(ClientesComentariosId id) {
        clientesComentariosRepository.deleteById(id);
    }

    @Override
    public Optional<Clientes> getClienteById(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Optional<Comentarios> getComentarioById(Long id) {
        return comentariosRepository.findById(id);
    }
}

