package br.com.tcs.treinamento.bean;


import br.com.tcs.treinamento.entity.Produto;
import br.com.tcs.treinamento.model.ProdutoVO;
import br.com.tcs.treinamento.service.produto.ProdutoServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name="cadastroProdutoBean")
@ViewScoped
public class CadastroProdutoBean {

    private ProdutoVO produtoVO = new ProdutoVO();
    private List<Produto> produtos;
    private transient ProdutoServiceImpl produtoService = new ProdutoServiceImpl();

    @PostConstruct
    public void init(){
        this.produtos = produtoService.listarProdutos();
    }

    public void cadastrarProduto(){
        Produto produtoEntity = new Produto();
        produtoEntity.setId(produtoVO.getId());
        produtoEntity.setNomeProduto(produtoVO.getNomeProduto());
        produtoEntity.setQuantidade(produtoVO.getQuantidade());
        produtoEntity.setPreco(produtoVO.getPreco());
        produtoEntity.setEmEstoque(produtoVO.getEmEstoque());
        produtoEntity.setAtivo(produtoVO.getAtivo() != null ? produtoVO.getAtivo() : true);

        produtoService.cadastrarProduto(produtoEntity);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Produto Salvo!"));

        limparCampos();
        this.produtos = produtoService.listarProdutos();
    }

    public void prepararEdicao(Produto p){
        this.produtoVO.setId(p.getId());
        this.produtoVO.setNomeProduto(p.getNomeProduto());
        this.produtoVO.setQuantidade(p.getQuantidade());
        this.produtoVO.setPreco(p.getPreco());
        this.produtoVO.setEmEstoque(p.getEmEstoque());
        this.produtoVO.setAtivo(p.getAtivo());
    }

    public void excluirProduto(Produto p){
        produtoService.excluirProduto(p);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Produto Excluído!"));
        this.produtos = produtoService.listarProdutos();
    }

    public void limparCampos(){
        this.produtoVO = new ProdutoVO();
    }

    public ProdutoVO getProdutoVO() {
        return produtoVO;
    }

    public void setProdutoVO(ProdutoVO produtoVO) {
        this.produtoVO = produtoVO;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
