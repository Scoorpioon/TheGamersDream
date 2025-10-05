package com.gamerdream.backend.DTOs;

public record EnderecoDTO(
    String rua,
    String numero,
    String bairro,
    String cidade,
    String estado,
    String cep
) {}