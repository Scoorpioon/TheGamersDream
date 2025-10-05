package com.gamerdream.backend.DTOs;

public record PessoaFisicaDTO(
    String nome,
    String cpf,
    String emailPessoal,
    String dataNascimento,
    String numCelular,
    PessoaJuridicaDTO empresa

) {}