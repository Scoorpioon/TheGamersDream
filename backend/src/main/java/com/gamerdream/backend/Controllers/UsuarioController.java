package com.gamerdream.backend.Controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gamerdream.backend.DTOs.ReqCadastroDTO;
import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.Usuario.UsuarioRepository;
import com.gamerdream.backend.Services.Usuario.UsuarioServices;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioServices servicoUsuario;

    @Autowired UsuarioRepository repoUsuario;

    @PostMapping("/cadastro")
    @Validated
    private ResponseEntity<?> cadastrarUsuario(@RequestBody ReqCadastroDTO dadosDoCadastro) {
        try {
            Usuario usuarioCadastrado = this.servicoUsuario.criarUsuario(dadosDoCadastro);

            URI uriDeDirecao = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(usuarioCadastrado.getId())
            .toUri();

            return ResponseEntity.created(uriDeDirecao).build();
        } catch(DataIntegrityViolationException violacao) {
            System.out.println("--- Dados ja cadastrados ou violacao da regra de dados ---");
            System.out.println(violacao.getMessage());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Houve uma violação de integridade de dados");

        }
    }

    @GetMapping("/minha-conta")
    private ResponseEntity<?> dadosUsuarioLogado(@AuthenticationPrincipal Jwt token) {
        String id = token.getSubject();
        Optional<Usuario> usuario = repoUsuario.findById(Long.parseLong(id));

        return ResponseEntity.ok(usuario);
    }
}