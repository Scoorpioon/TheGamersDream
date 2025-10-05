package com.gamerdream.backend.Models.Usuarios;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gamerdream.backend.DTOs.ReqLoginDTO;
import com.gamerdream.backend.Models.Produtos.Produto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nome_usuario", length = 46, nullable=false)
    private String username;

    @Column(name = "email", length=60, nullable=false)
    private String email;

    @Column(name = "senha", length=256, nullable=false)
    private String password;

    @Column(name = "num_celular", columnDefinition = "CHAR(11)", nullable=false)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao", nullable=false)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_edicao")
    private Date dataEdicao; // TODA VEZ QUE UM USUÁRIO MUDAR QUALQUER DADO DA CONTA, POR MENOR QUE SEJA, A DATA SERÁ SALVA!

    /* Spring Security */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return "secreto!";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public boolean loginCorreto(ReqLoginDTO requestLogin, PasswordEncoder passEncoder) {
        return passEncoder.matches(requestLogin.password(), this.password);
    }

    /* =============================================================== */

    public Usuario(String username, String email, String password, String telefone, Empresa empresa, Date dataCriacao) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
        this.empresa = empresa;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String username, String email, String password, String telefone, Pessoa pessoa, Date dataCriacao) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
        this.pessoa = pessoa;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String username, String email, String password, String telefone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
    }

    public Long getId() {
        return idUsuario;
    }

    public void setId(Long id) {
        this.idUsuario = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

       public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}