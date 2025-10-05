package com.gamerdream.backend.Services;

import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.EnderecoDTO;
import com.gamerdream.backend.Models.Endereco;


@Service
public class EnderecoService {

    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();

        endereco.setRua(enderecoDTO.rua());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setCep(enderecoDTO.cep());

        return endereco;
    }
}