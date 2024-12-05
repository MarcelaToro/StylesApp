package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Peluqueria;
import com.proyecto.stylessapp.repository.PeluqueriaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class PeluqueriaServiceImpl implements PeluqueriaService {

    @Autowired
    private PeluqueriaRepository peluqueriaRepository;
    
    // Inyectar BCryptPasswordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Peluqueria savePeluqueria(Peluqueria peluqueria) {
        // Cifrar la contraseña antes de guardar el cliente
        peluqueria.setPassword(passwordEncoder.encode(peluqueria.getPassword()));
        return peluqueriaRepository.save(peluqueria);
    }

    @Override
    public Optional<Peluqueria> getPeluqueriaById(Long peluqueriaId) {
        return peluqueriaRepository.findById(peluqueriaId);
    }

    @Override
    public List<Peluqueria> getAllPeluquerias() {
        return peluqueriaRepository.findAll();
    }

    @Override
    public Peluqueria updatePeluqueria(Peluqueria peluqueria) {
        // Cifrar la contraseña antes de actualizar el cliente
        peluqueria.setPassword(passwordEncoder.encode(peluqueria.getPassword()));
        return peluqueriaRepository.save(peluqueria);
    }

    @Override
    public void deletePeluqueria(Long peluqueriaId) {
        peluqueriaRepository.deleteById(peluqueriaId);
    }
    
    @Override
    public Optional<Peluqueria> getPeluqueriaByEmail(String email) {
        return peluqueriaRepository.findByEmail(email);
    }
    
    @Override
    public Optional<Peluqueria> findByResetToken(String token) {
        return peluqueriaRepository.findByResetToken(token);
    }
    
    // Nuevo método para generar el token y fecha de expiración
    public void createPasswordResetTokenForClient(Peluqueria peluqueria) {
        String token = RandomStringUtils.randomAlphanumeric(30);  // Genera un token aleatorio de 30 caracteres
        peluqueria.setResetToken(token);  // Guarda el token en el cliente
        peluqueria.setTokenExpiryDate(new Date(System.currentTimeMillis() + 86400000));  // Validez del token: 24 horas
        peluqueriaRepository.save(peluqueria);  // Guarda el cliente actualizado con el token y la fecha de expiración
    }
}
