package com.gamerdream.backend.Controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.gamerdream.backend.Services.UsuarioServices;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamerdream.backend.DTOs.ReqLoginDTO;
import com.gamerdream.backend.DTOs.ResLoginDTO;
import com.gamerdream.backend.Exceptions.CredenciaisInvalidasEx;
import com.gamerdream.backend.Exceptions.UsuarioNaoEncontradoEx;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private final PasswordEncoder criptografadorDeSenha;

    @Autowired
    private UsuarioServices servUsuario;

    private final JwtEncoder jwtEncoder;

    public AutenticacaoController(JwtEncoder jwtEncoder, PasswordEncoder criptografadorDeSenha) {
        this.jwtEncoder = jwtEncoder;
        this.criptografadorDeSenha = criptografadorDeSenha;
    }

    @PostMapping("/login")
    public ResponseEntity<ResLoginDTO> logar(@RequestBody ReqLoginDTO dados) {

        var usuario = servUsuario.procurarUsername(dados.username());

        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoEx("O usuario nao foi encontrado...");
        } else if(!usuario.get().loginCorreto(dados, criptografadorDeSenha)) {
            throw new CredenciaisInvalidasEx("Usuario ou senha invalidos!");    
        }

        var agora = Instant.now();
        Long expiraEm = 1620L; // se parar de funcionar, muda pra var

        var claims = JwtClaimsSet.builder()
                     .issuer("gamerbackend")
                     .subject(String.valueOf(usuario.get().getIdUsuario()))
                     .issuedAt(agora)
                     .expiresAt(agora.plusSeconds(expiraEm)).build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new ResLoginDTO(jwtValue, expiraEm));
    }
}