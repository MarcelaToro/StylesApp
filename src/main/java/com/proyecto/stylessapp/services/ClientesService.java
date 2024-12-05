
package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Clientes;
import java.util.List;
import java.util.Optional;


public interface ClientesService {
    
   Clientes saveCliente(Clientes cliente);
   
    Optional<Clientes> getClienteById(Long id);
    
    List<Clientes> getAllClientes();
    
    Clientes updateCliente(Clientes cliente);
    
    void deleteCliente(Long id);
    
    Optional<Clientes> getClienteByEmail(String email);
    
    Optional<Clientes> findByResetToken(String token);
}
