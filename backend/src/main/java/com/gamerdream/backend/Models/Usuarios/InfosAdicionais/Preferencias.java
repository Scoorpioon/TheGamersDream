package com.gamerdream.backend.Models.Usuarios.InfosAdicionais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Preferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreferencia;

    @Column(name = "nome_produto", length = 20)
    private String nomeProduto;

    // aqui vai ser tipo tags de forma generalizada. Por exemplo: Computador, Peças de computador, videogame, placa de vídeo, etc...

    public Long getIdPreferencia() {
        return idPreferencia;
    }

    public void setIdPreferencia(Long idPreferencia) {
        this.idPreferencia = idPreferencia;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}