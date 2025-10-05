package com.gamerdream.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.PessoaFisicaDTO;
import com.gamerdream.backend.DTOs.PessoaJuridicaDTO;
import com.gamerdream.backend.Models.Usuarios.Empresa;
import com.gamerdream.backend.Models.Usuarios.Pessoa;
import com.gamerdream.backend.Repositories.EmpresaRepository;
import com.gamerdream.backend.Repositories.PessoaRepository;

@Service
public class EmpresaServices {
    
    @Autowired
    EmpresaRepository repositorioPJ;

    @Autowired
    PessoaRepository repositorioPF;

    public Empresa definirDadosPJ(PessoaJuridicaDTO dadosEmpresa, PessoaFisicaDTO dadosResponsavel) {
        Empresa empresa = new Empresa();
        Pessoa responsavel = new Pessoa();

        empresa.setIdEmpresa(null);
        empresa.setCnpj(dadosEmpresa.cnpj());
        empresa.setRazaoSocial(dadosEmpresa.razaoSocial());
        empresa.setInscricaoEstadual(dadosEmpresa.inscricao());
        empresa.setPlano(dadosEmpresa.plano());
        
        responsavel.setIdPessoa(null);
        responsavel.setNome(dadosResponsavel.nome());
        responsavel.setCpf(dadosResponsavel.cpf());
        responsavel.setEmail(dadosResponsavel.emailPessoal());
        responsavel.setDataNascimento(dadosResponsavel.dataNascimento());
        responsavel.setNumCelular(dadosResponsavel.numCelular());
        
        empresa.setPessoaResponsavel(responsavel);
        
        this.repositorioPF.save(responsavel);
        this.repositorioPJ.save(empresa);         

        return empresa;
    }
}