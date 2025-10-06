package com.gamerdream.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamerdream.backend.DTOs.ProdutoDTO;
import com.gamerdream.backend.DTOs.RespostaAPI;
import com.gamerdream.backend.Exceptions.BancoDeDadosEx;
import com.gamerdream.backend.Models.Produtos.Produto;
import com.gamerdream.backend.Services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.security.oauth2.jwt.Jwt;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService servProduto;

    @PostMapping("/anunciar")
    public ResponseEntity<?> anunciarProduto(@RequestBody ProdutoDTO informacoesProduto, @AuthenticationPrincipal Jwt token) {

        try {
            String idUsuario = token.getSubject();

            Produto pecaAnunciada = servProduto.cadastrarProduto(informacoesProduto, Long.parseLong(idUsuario));
            System.out.println(pecaAnunciada.getDescricao());
            
        } catch(NullPointerException error) {
            System.out.println("Erro do usuario: " + error.getMessage());
        } catch(DataIntegrityViolationException error) {
            System.out.println("=====================");
            System.out.println(error.getMessage());
            System.out.println("=====================");

            throw new BancoDeDadosEx("Ocorreu um erro ao salvar os produtos. Tem algum dado inválido aí.");
        }

        return ResponseEntity.ok(new RespostaAPI(200, "Produtinho criado com sucesso."));
    }
}