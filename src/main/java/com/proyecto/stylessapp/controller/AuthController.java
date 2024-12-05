package com.proyecto.stylessapp.controller;

import com.proyecto.stylessapp.model.Rol;
import com.proyecto.stylessapp.model.Usuario;
import com.proyecto.stylessapp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";  // Vista del formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String username, 
                                @RequestParam String password, 
                                @RequestParam String rol, 
                                Model model) {
        Usuario usuario = usuarioService.validarCredenciales(username, password);
        
        if (usuario != null) {
            // Verifica el rol seleccionado en el formulario
            if (rol.equals("Clientes") && usuario.getRol() == Rol.ROLE_CLIENTES) {
                return "redirect:/clientes/registro";  // Redirige a la página de cliente
            } else if (rol.equals("Peluqueria") && usuario.getRol() == Rol.ROLE_PELUQUERIA) {
                return "redirect:/peluqueria/formularioPeluqueria";  // Redirige a la página de peluquería/administrador
            }
        }

        // Si las credenciales o el rol no coinciden
        model.addAttribute("error", "Credenciales o rol incorrecto");
        return "login";
    }
}
