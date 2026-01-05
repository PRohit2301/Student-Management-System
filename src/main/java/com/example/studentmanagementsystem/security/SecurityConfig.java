package com.example.studentmanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/admin-login.html",
                                "/student-login.html",
                               // "/admin-dashboard.html",
                               // "/student-dashboard.html",
                                "/css/**",
                                "/js/**"
                        ).permitAll()

                        .requestMatchers("/admin-dashboard.html").hasAuthority("ADMIN")
                        .requestMatchers("/student-dashboard.html").hasAuthority("STUDENT")

                        .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/api/student/**").hasAuthority("STUDENT")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/student-login.html")// common entry page
                        .loginProcessingUrl("/login")
                        .successHandler(loginSuccessHandler)  // ✅ ROLE BASED
                       .failureUrl("/student-login.html?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index.html")
                )
                .sessionManagement(session -> session
                        .sessionFixation().migrateSession()

                );



        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // TEMP only
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
