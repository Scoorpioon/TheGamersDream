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

    // @Column(name = "tags_preferencias_compra")
    
    public Long getId() {
        return idPessoa;
    }

    public void setId(Long id) {
        this.idPessoa = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}