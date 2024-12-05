package com.proyecto.stylessapp.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        // Redirigir según el rol del usuario
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_PELUQUERIA")) {
                // Redirigir a la página de administración (Peluquería)
                response.sendRedirect("/peluqueria/dashboard");
                return;
            } else if (authority.getAuthority().equals("ROLE_CLIENTE")) {
                // Redirigir a la página de cliente
                response.sendRedirect("/clientes/dashboard");
                return;
            }
        }
        // Si no se encuentra un rol, redirigir a una página por defecto
        response.sendRedirect("/default");
    }
}

