package com.gamerdream.backend.Services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.ReqCadastroDTO;
import com.gamerdream.backend.Models.Usuarios.Empresa;
import com.gamerdream.backend.Models.Usuarios.Pessoa;
import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServices {

    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired
    private PessoaServices servicosPessoa;

    @Autowired
    private EmpresaServices servicosEmpresa;

    UsuarioServices(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> procurarUsername(String username) {
        return repositorioUsuario.findByUsername(username);
    }

    @Transactional
    public Usuario criarUsuario(ReqCadastroDTO requisicaoDoCadastro) {
        Usuario novoUsuario = new Usuario();
        
        Date momentoAtual = new Date();

        novoUsuario.setId(null);
        novoUsuario.setUsername(requisicaoDoCadastro.informacoesDeLogin().username());
        novoUsuario.setPassword(passwordEncoder.encode(requisicaoDoCadastro.informacoesDeLogin().password()));
        novoUsuario.setEmail(requisicaoDoCadastro.informacoesDeLogin().email());
        novoUsuario.setTelefone(requisicaoDoCadastro.informacoesDeLogin().celular());
        novoUsuario.setDataCriacao(momentoAtual);

        if(requisicaoDoCadastro.tipoUsuario().equals("PF")) {
            Pessoa dadosDaPessoa = this.servicosPessoa.definirDadosPF(requisicaoDoCadastro.informacoesPF());
            novoUsuario.setPessoa(dadosDaPessoa);

        } else if(requisicaoDoCadastro.tipoUsuario().equals("PJ")) {
            Empresa dadosEmpresa = this.servicosEmpresa.definirDadosPJ(requisicaoDoCadastro.informacoesPJ(), requisicaoDoCadastro.informacoesPF());
            
            novoUsuario.setEmpresa(dadosEmpresa);
        }

        this.repositorioUsuario.save(novoUsuario);

        return novoUsuario;
    }
}