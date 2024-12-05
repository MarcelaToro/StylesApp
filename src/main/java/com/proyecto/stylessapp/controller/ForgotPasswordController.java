
package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Clientes;
import com.proyecto.stylessapp.services.ClientesService;
import com.proyecto.stylessapp.services.EmailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class ForgotPasswordController {

    @Autowired
    private ClientesService clienteService;
    
    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Inyecta BCryptPasswordEncoder

    // Muestra el formulario de "Olvidé mi contraseña"
    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";  // Página con el formulario
    }

    // Procesa la solicitud de restablecimiento de contraseña
    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam("email") String email, Model model) {
        Optional<Clientes> cliente = clienteService.getClienteByEmail(email);

        if (cliente.isPresent()) {
            // Generar un token de restablecimiento
            String token = RandomStringUtils.randomAlphanumeric(30);

            // Asignar el token y la fecha de expiración (24 horas desde el momento actual)
            Clientes client = cliente.get();
            client.setResetToken(token);
            client.setTokenExpiryDate(new Date(System.currentTimeMillis() + 86400000));  // 24 horas
            
 clienteService.saveCliente(client);
            
            // Enviar el email con el enlace de recuperación
            emailService.sendPasswordResetEmail(email, token);
            // Aquí deberías enviar un correo electrónico con el enlace de restablecimiento
            // Ejemplo: "http://localhost:8080/reset-password?token=" + token

            model.addAttribute("message", "Se ha enviado un enlace de recuperación a tu correo electrónico.");
        } else {
            model.addAttribute("error", "No se encontró una cuenta con ese correo.");
        }

        return "forgot-password";  // Retorna la página con el mensaje de éxito o error
    }

    // Muestra el formulario para ingresar la nueva contraseña
    @GetMapping("/reset-password")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
        // Buscar el cliente por el token de restablecimiento
        Optional<Clientes> cliente = clienteService.findByResetToken(token);

        if (cliente.isPresent()) {
            // Verificar si el token ha expirado
            Clientes client = cliente.get();
            if (client.getTokenExpiryDate().before(new Date())) {
                model.addAttribute("error", "El token ha expirado.");
                return "forgot-password";  // Si el token ha expirado, redirigir
            }

            model.addAttribute("token", token);
            return "reset-password";  // Mostrar el formulario de restablecer contraseña
        } else {
            model.addAttribute("error", "Token inválido o expirado.");
            return "forgot-password";  // Redirigir si el token es inválido
        }
    }

    // Procesa el formulario de restablecimiento de contraseña
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, 
                                @RequestParam("password") String password, 
                                Model model) {
        Optional<Clientes> cliente = clienteService.findByResetToken(token);

        if (cliente.isPresent()) {
            Clientes client = cliente.get();

            // Verificar si el token ha expirado
            if (client.getTokenExpiryDate().before(new Date())) {
                model.addAttribute("error", "El token ha expirado.");
                return "reset-password";
            }

            // Cifrar la nueva contraseña antes de guardarla
            client.setPassword(passwordEncoder.encode(password));
            client.setResetToken(null);  // Limpiar el token después de usarlo
            client.setTokenExpiryDate(null);  // Limpiar la fecha de expiración del token
            clienteService.saveCliente(client);  // Guardar los cambios

            return "redirect:/login?resetSuccess";
        } else {
            model.addAttribute("error", "Token inválido.");
            return "reset-password";
        }
    }
}