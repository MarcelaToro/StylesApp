package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.stylessapp.repository.ClientesRepository;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clienteRepository;
    
    // Inyectar BCryptPasswordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public Clientes saveCliente(Clientes cliente) {
        // Cifrar la contraseña antes de guardar el cliente
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Clientes> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes updateCliente(Clientes cliente) {
        // Cifrar la contraseña antes de actualizar el cliente
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Clientes> getClienteByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    
    @Override
    public Optional<Clientes> findByResetToken(String token) {
        return clienteRepository.findByResetToken(token);
    }
    
    // Nuevo método para generar el token y fecha de expiración
    public void createPasswordResetTokenForClient(Clientes cliente) {
        String token = RandomStringUtils.randomAlphanumeric(30);  // Genera un token aleatorio de 30 caracteres
        cliente.setResetToken(token);  // Guarda el token en el cliente
        cliente.setTokenExpiryDate(new Date(System.currentTimeMillis() + 86400000));  // Validez del token: 24 horas
        clienteRepository.save(cliente);  // Guarda el cliente actualizado con el token y la fecha de expiración
    }
}