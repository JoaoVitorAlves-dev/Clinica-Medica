package com.romeuzxg.clinica_medica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, TokenFilter filter) {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios/auth/cadastrar", "/usuarios/auth/login", "/usuarios/auth/refresh").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuarios/auth/atualizar/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/usuarios/auth/listar/**").hasAnyRole("ADMIN", "MEDICO")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/auth/deletar/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/consultas/cadastrar").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/consultas/atualizar/{id}").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/consultas/listar/**").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/consultas/deletar/{id}").hasAnyRole("MEDICO", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/convenios/cadastrar").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/convenios/atualizar/**").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/convenios/listar/**").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/convenios/deletar/{id}").hasAnyRole("MEDICO", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/especialidades/cadastrar").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/especialidades/atualizar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/especialidades/listar/**").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/especialidades/deletar/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/medicos/cadastrar").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/medicos/atualizar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/medicos/listar/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/medicos/deletar/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/pacientes/cadastrar").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/pacientes/atualizar/{id}").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/pacientes/listar/**").hasAnyRole("MEDICO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/pacientes/deletar/{id}").hasAnyRole("MEDICO", "ADMIN")

                        .anyRequest().authenticated())
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

}
