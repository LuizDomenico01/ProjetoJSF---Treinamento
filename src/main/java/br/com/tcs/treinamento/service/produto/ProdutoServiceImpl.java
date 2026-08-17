package br.com.tcs.treinamento.service.produto;

import br.com.tcs.treinamento.dao.ProdutoDAO;
import br.com.tcs.treinamento.entity.Produto;

import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    @Override
    public void cadastrarProduto(Produto produtoEntity){
        produtoDAO.cadastrarProduto(produtoEntity);
    }

    @Override
    public void excluirProduto(Produto produtoEntity){
        produtoDAO.excluirProduto(produtoEntity);
    }

    @Override
    public List<Produto> listarProdutos(){
        return produtoDAO.listarProdutos();
    }
}
