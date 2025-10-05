package com.gamerdream.backend.DTOs;

import java.util.Date;

public record UsuarioDTO(
    String username,
    String password,
    String email,
    String celular,
    PessoaJuridicaDTO empresaAssociada,
    PessoaFisicaDTO dadosPessoais,
    Date dataDeCriacao,
    Date momentoDeEdicao
) {}