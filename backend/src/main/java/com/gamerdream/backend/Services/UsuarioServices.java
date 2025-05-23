package com.gamerdream.backend.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.ConsumidorRepository;
import com.gamerdream.backend.Repositories.EmpresaRepository;
import com.gamerdream.backend.Repositories.UsuarioRepository;

@Service
public class UsuarioServices {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired 
    private EmpresaRepository repositorioEmpresa;

    @Autowired
    private ConsumidorRepository repositorioConsumidor;

    /* private Usuario criarUsuario(String nome, String email, String senha, String telefone, Boolean usuarioEmpresa) {
        Optional<Usuario> novoUsuario = new Usuario(nome, email, senha, telefone);
    } */
}