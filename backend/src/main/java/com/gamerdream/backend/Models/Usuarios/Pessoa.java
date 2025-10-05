package com.gamerdream.backend.Models.Usuarios;

import com.gamerdream.backend.Models.Endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false)
    private String cpf;

    @Column(name = "email", length = 60, nullable = true)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "num_celular", columnDefinition = "CHAR(11)", nullable = true)
    private String numCelular;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "idEndereco")
    private Endereco endereco;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // @Column(name = "tags_preferencias_compra")
    
}