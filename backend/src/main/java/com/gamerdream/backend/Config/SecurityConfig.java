package com.gamerdream.backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // libera tudo
            )
            .csrf(csrf -> csrf.disable()); // desabilita CSRF (evita erros em POST no dev)

        return http.build();
    }

    // Configuração padrão de permissões de acesso na API. Desabilitado temporariamente até o desenvolvimento do JWT
    /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(auth -> auth

        .requestMatchers("/h2-console/**").permitAll()
        .requestMatchers("/autenticacao/**").permitAll()
        .requestMatchers("/usuario/cadastro").permitAll()
        .requestMatchers("/usuario/**").authenticated()

        .anyRequest().authenticated()
        )
        .formLogin(form -> form.permitAll())
        .httpBasic(null)
        .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
        .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    } */

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario = User.withUsername("admin")
        .password("{noop}123")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(usuario);
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}