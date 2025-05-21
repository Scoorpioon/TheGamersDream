package com.gamerdream.backend.Models.Usuarios;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nome", length = 46, nullable=false)
    private String nome;

    @Column(name = "email", length=60, nullable=false)
    private String email;

    @Column(name = "senha", length=256, nullable=false)
    private String senha;

    @Column(name = "num_celular", columnDefinition = "CHAR(11)", nullable=false)
    private String telefone;

    // Relacionamento com tabela de anunciante ou consumidor |

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_consumidor", referencedColumnName = "idConsumidor")
    private Consumidor consumidor;

    // Tabela de preferências (Configurações) |

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao", nullable=false)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_edicao", nullable=false)
    private Date dataEdicao; // TODA VEZ QUE UM USUÁRIO MUDAR QUALQUER DADO DA CONTA, POR MENOR QUE SEJA, A DATA SERÁ SALVA!

    public Long getId() {
        return idUsuario;
    }

    public void setId(Long id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}