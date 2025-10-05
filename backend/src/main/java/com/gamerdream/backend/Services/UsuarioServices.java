package com.gamerdream.backend.Services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.ReqLoginDTO;
import com.gamerdream.backend.Models.Endereco;
import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.ConsumidorRepository;
import com.gamerdream.backend.Repositories.EmpresaRepository;
import com.gamerdream.backend.Repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServices {

    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired 
    private EmpresaRepository repositorioEmpresa;

    @Autowired
    private ConsumidorRepository repositorioConsumidor;

    UsuarioServices(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> procurarUsername(String username) {
        return repositorioUsuario.findByUsername(username);
    }

    @Transactional
    public Usuario criarUsuario(Usuario dadosRecebidosUsuario) {
        Date momentoAtual = new Date();

        dadosRecebidosUsuario.setId(null);
        dadosRecebidosUsuario.setSenha(passwordEncoder.encode(dadosRecebidosUsuario.getSenha()));
        dadosRecebidosUsuario.setDataCriacao(momentoAtual);

        this.repositorioUsuario.save(dadosRecebidosUsuario);

        return dadosRecebidosUsuario;
    }
}