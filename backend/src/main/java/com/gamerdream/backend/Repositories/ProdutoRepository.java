package com.gamerdream.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamerdream.backend.Models.Produtos.Produto;
import com.gamerdream.backend.Models.Usuarios.Empresa;
import com.gamerdream.backend.Models.Usuarios.Pessoa;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByPessoaIdPessoa(Long p_pessoaId);
    List<Produto> findByEmpresaIdEmpresa(Long p_empresaId);
}