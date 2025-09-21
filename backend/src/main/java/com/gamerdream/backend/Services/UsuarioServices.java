package com.gamerdream.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.ConsumidorRepository;
import com.gamerdream.backend.Repositories.EmpresaRepository;
import com.gamerdream.backend.Repositories.UsuarioRepository;

@Service
public class UsuarioServices implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Autowired 
    private EmpresaRepository repositorioEmpresa;

    @Autowired
    private ConsumidorRepository repositorioConsumidor;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorioUsuario.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar o usuário. Tenta novamente!"));
    }

    /* private Usuario criarUsuario(String nome, String email, String senha, String telefone, Boolean usuarioEmpresa) {
        Optional<Usuario> novoUsuario = new Usuario(nome, email, senha, telefone);
    } */
}