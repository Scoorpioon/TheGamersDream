package com.gamerdream.backend.DTOs;

public record PessoaJuridicaDTO(
    String cnpj,
    String razaoSocial,
    String inscricao,
    PessoaFisicaDTO pessoaResponsavel,
    int plano

) {}