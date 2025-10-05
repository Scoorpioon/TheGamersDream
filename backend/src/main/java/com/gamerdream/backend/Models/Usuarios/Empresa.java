package com.gamerdream.backend.Models.Usuarios;

import com.gamerdream.backend.Models.Endereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(name = "cnpj", columnDefinition = "CHAR(14)", nullable = false)
    private String cnpj;

    @Column(name = "razao_social", length = 32, nullable = false)
    private String razaoSocial;

    @Column(name = "inscricao_estadual", length = 12, nullable = true)
    private String inscricaoEstadual;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoaResponsavel;

    @Column(name = "plano", nullable = false)
    private int plano;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "idEndereco")
    private Endereco endereco;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Pessoa getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(Pessoa pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}