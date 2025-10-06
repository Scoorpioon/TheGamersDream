package com.gamerdream.backend.DTOs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gamerdream.backend.Models.Produtos.TipoProduto;
import com.gamerdream.backend.Models.Usuarios.Empresa;
import com.gamerdream.backend.Models.Usuarios.Pessoa;

public record ProdutoDTO(
    String nome,
    String descricao,
    BigDecimal preco,
    List<String> detalhesTecnicos,
    Date dataPublicacao,
    Date dataEdicao,
    TipoProduto tipo,
    Empresa empresa,
    Pessoa pessoa
) {}