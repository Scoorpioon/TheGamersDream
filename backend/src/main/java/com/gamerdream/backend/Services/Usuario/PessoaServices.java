package com.gamerdream.backend.Services.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.PessoaFisicaDTO;
import com.gamerdream.backend.Models.Endereco;
import com.gamerdream.backend.Models.Usuarios.Pessoa;
import com.gamerdream.backend.Repositories.Usuario.EnderecoRepository;
import com.gamerdream.backend.Repositories.Usuario.PessoaRepository;

@Service
public class PessoaServices {

    @Autowired
    private PessoaRepository repositorioPessoaFisica;

    @Autowired
    EnderecoRepository repositorioEndereco;

    @Autowired
    EnderecoService servEndereco;

    public Pessoa definirDadosPF(PessoaFisicaDTO dadosPessoa) {
        Pessoa dadosDoCamarada = new Pessoa();
        Endereco enderecoPessoal = this.servEndereco.cadastrarEndereco(dadosPessoa.endereco());

        dadosDoCamarada.setIdPessoa(null); // bora evitar um id injection né kkkkk
        dadosDoCamarada.setNome(dadosPessoa.nome());
        dadosDoCamarada.setCpf(dadosPessoa.cpf());
        dadosDoCamarada.setEmail(dadosPessoa.emailPessoal());
        dadosDoCamarada.setDataNascimento(dadosPessoa.dataNascimento());
        dadosDoCamarada.setNumCelular(dadosPessoa.numCelular());

        dadosDoCamarada.setEndereco(enderecoPessoal);

        this.repositorioPessoaFisica.save(dadosDoCamarada);
        this.repositorioEndereco.save(enderecoPessoal);

        return dadosDoCamarada;
    }
}