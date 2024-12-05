package com.proyecto.stylessapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String toEmail, String token) {
        String resetUrl = "http://localhost:8080/reset-password?token=" + token;
        String subject = "Restablece tu contraseña";
        String message = "Hola,\n\nPara restablecer tu contraseña, haz clic en el siguiente enlace: " + resetUrl +
                         "\n\nSi no solicitaste este cambio, puedes ignorar este mensaje.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(toEmail);
        email.setSubject(subject);
        email.setText(message);

        try {
            mailSender.send(email);
            logger.info("Correo de restablecimiento de contraseña enviado a {}", toEmail);
        } catch (Exception e) {
            logger.error("Error al enviar el correo de restablecimiento a {}: {}", toEmail, e.getMessage());
        }
    }
}
