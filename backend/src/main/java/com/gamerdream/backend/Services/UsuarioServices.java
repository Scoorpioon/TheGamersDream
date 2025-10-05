package com.gamerdream.backend.Services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.ReqCadastroDTO;
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
    public Usuario criarUsuario(ReqCadastroDTO requisicaoDoCadastro) {
        Date momentoAtual = new Date();

        Usuario novoUsuario = new Usuario();

        novoUsuario.setId(null);
        novoUsuario.setNome(requisicaoDoCadastro.informacoesDeLogin().username());
        novoUsuario.setSenha(passwordEncoder.encode(requisicaoDoCadastro.informacoesDeLogin().password()));
        novoUsuario.setEmail(requisicaoDoCadastro.informacoesDeLogin().email());
        novoUsuario.setTelefone(requisicaoDoCadastro.informacoesDeLogin().celular());
        novoUsuario.setDataCriacao(momentoAtual);

        this.repositorioUsuario.save(novoUsuario);

        return novoUsuario;
    }
}