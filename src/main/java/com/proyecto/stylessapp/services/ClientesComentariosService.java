package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Clientes;
import com.proyecto.stylessapp.model.Comentarios;
import com.proyecto.stylessapp.model.ClientesComentarios;
import com.proyecto.stylessapp.model.ClientesComentariosId;

import java.util.List;
import java.util.Optional;

public interface ClientesComentariosService {
    ClientesComentarios saveClientesComentarios(ClientesComentarios clientesComentarios);
    Optional<ClientesComentarios> getClientesComentariosById(ClientesComentariosId id);
    List<ClientesComentarios> getAllClientesComentarios();
    ClientesComentarios updateClientesComentarios(ClientesComentarios clientesComentarios);
    void deleteClientesComentarios(ClientesComentariosId id);
    Optional<Clientes> getClienteById(Long id);
    Optional<Comentarios> getComentarioById(Long id);
}
