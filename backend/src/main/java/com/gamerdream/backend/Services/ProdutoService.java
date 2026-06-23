package com.gamerdream.backend.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.gamerdream.backend.DTOs.ProdutoDTO;
import com.gamerdream.backend.Models.Produtos.Produto;
import com.gamerdream.backend.Models.Usuarios.Usuario;
import com.gamerdream.backend.Repositories.ProdutoRepository;
import com.gamerdream.backend.Repositories.Usuario.UsuarioRepository;

import org.springframework.security.oauth2.jwt.Jwt;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    UsuarioRepository repoUsuario;

    @Autowired
    ProdutoRepository repoProduct;
    
    @Transactional
    public Produto cadastrarProduto(ProdutoDTO informacoesProduto, Long idUsuario) {
        Produto peca = new Produto();
        Optional<Usuario> infoDoUsuario = repoUsuario.findById(idUsuario); 

        peca.setIdProduto(null);
        peca.setNome(informacoesProduto.nome());
        peca.setDescricao(informacoesProduto.descricao());
        peca.setPreco(informacoesProduto.preco());
        // setDetalhesTecnicos
        peca.setDataPublicacao(new Date());
        peca.setTipo(informacoesProduto.tipo());

        if(infoDoUsuario.get().getPessoa() != null) {
            peca.setPessoa((infoDoUsuario.get().getPessoa()));
        } else if(infoDoUsuario.get().getEmpresa() != null) {
            peca.setEmpresa(infoDoUsuario.get().getEmpresa());
        } else {
            throw new EntityNotFoundException("Produto sem anunciante valido. Nao sera possivel realizar a transacao");
        }

        this.repoProduct.save(peca);

        return peca;
    }

    public List<Produto> getAllLoggedUserProducts(@AuthenticationPrincipal Jwt p_token) {
        try {
            Long l_userId = Long.parseLong(p_token.getSubject());
            List<Produto> l_products = repoProduct.findByPessoaIdPessoa(l_userId);

            return l_products;
            
        } catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }
}