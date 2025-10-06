package com.gamerdream.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamerdream.backend.Models.Produtos.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}