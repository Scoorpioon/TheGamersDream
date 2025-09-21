package com.gamerdream.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamerdream.backend.Services.UsuarioServices;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
    @Autowired
    private UsuarioServices servicoUsuario;

    @Autowired 
    private AuthenticationManager authenticationManager;

    // Esse aqui será só pro login
}