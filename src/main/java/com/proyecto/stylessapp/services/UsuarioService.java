package com.proyecto.stylessapp.services;

import com.proyecto.stylessapp.model.Usuario;
import com.proyecto.stylessapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrar(Usuario usuario) {
        // Encriptar contraseña antes de guardar
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public Usuario validarCredenciales(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null && new BCryptPasswordEncoder().matches(password, usuario.getPassword())) {
            return usuario;
        }
        return null;
    }
}

