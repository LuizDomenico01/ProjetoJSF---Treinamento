package br.com.tcs.treinamento.service.produto;

import br.com.tcs.treinamento.entity.Produto;

import java.util.List;

public interface ProdutoService {

    void cadastrarProduto(Produto produtoEntity);
    void excluirProduto(Produto produtoEntity);
    List<Produto> listarProdutos();
}
