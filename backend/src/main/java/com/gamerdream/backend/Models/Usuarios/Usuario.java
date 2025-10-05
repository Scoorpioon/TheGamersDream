package com.gamerdream.backend.Models.Usuarios;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gamerdream.backend.DTOs.ReqLoginDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
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

    public String getNome() {
        return username;
    }

    public void setNome(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return password;
    }

    public void setSenha(String password) {
        this.password = password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}