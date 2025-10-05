package com.gamerdream.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.Repositories.UsuarioRepository;

@Service
public class PessoaServices {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;
}