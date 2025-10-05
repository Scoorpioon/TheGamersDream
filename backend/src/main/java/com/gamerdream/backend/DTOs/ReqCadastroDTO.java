package com.gamerdream.backend.DTOs;

public record ReqCadastroDTO(
    String tipoUsuario, // sempre preenchido
    UsuarioDTO informacoesDeLogin, // sempre preenchido
    PessoaFisicaDTO informacoesPF,
    PessoaJuridicaDTO informacoesPJ
) {}