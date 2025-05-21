package com.gamerdream.backend.Models.Usuarios;

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

    @Column(name = "sede_principal", length = 40, nullable = false)
    private String sedePrincipal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    private Usuario usuario;
}