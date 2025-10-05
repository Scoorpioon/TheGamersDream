package com.gamerdream.backend.DTOs;

public record PessoaJuridicaDTO(
    String cnpj,
    String razaoSocial,
    String inscricao,
    int plano,
    PessoaFisicaDTO pessoaResponsavel,
    EnderecoDTO endereco

) {}