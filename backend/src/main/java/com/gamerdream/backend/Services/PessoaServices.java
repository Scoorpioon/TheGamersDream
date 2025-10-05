package com.gamerdream.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.PessoaFisicaDTO;
import com.gamerdream.backend.Models.Usuarios.Pessoa;
import com.gamerdream.backend.Repositories.PessoaRepository;

@Service
public class PessoaServices {

    @Autowired
    private PessoaRepository repositorioPessoaFisica;

    public Pessoa definirDadosPF(PessoaFisicaDTO dadosPessoa) {
        Pessoa dadosDoCamarada = new Pessoa();

        dadosDoCamarada.setIdPessoa(null); // bora evitar um id injection né kkkkk
        dadosDoCamarada.setNome(dadosPessoa.nome());
        dadosDoCamarada.setCpf(dadosPessoa.cpf());
        dadosDoCamarada.setEmail(dadosPessoa.emailPessoal());
        dadosDoCamarada.setDataNascimento(dadosPessoa.dataNascimento());
        dadosDoCamarada.setNumCelular(dadosPessoa.numCelular());

        this.repositorioPessoaFisica.save(dadosDoCamarada);

        return dadosDoCamarada;
    }
}