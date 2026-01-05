package com.example.studentmanagementsystem.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        for (GrantedAuthority authority : authentication.getAuthorities()) {

            String role = authority.getAuthority();

            if (role.equals("ADMIN")) {
                response.sendRedirect("/admin-dashboard.html");
                return;
            }

            if (role.equals("STUDENT")) {
                response.sendRedirect("/student-dashboard.html");
                return;
            }
        }

        // fallback
        response.sendRedirect("/index.html");
    }
}
