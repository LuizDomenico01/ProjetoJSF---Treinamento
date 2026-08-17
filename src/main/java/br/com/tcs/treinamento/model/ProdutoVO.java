package br.com.tcs.treinamento.model;

public class ProdutoVO {

    private Long id;
    private String nomeProduto;
    private Integer quantidade;
    private Double preco;
    private Boolean emEstoque;
    private Boolean ativo = true;

    public ProdutoVO(){}

    public ProdutoVO(Long id, String nomeProduto, Integer quantidade, Double preco, Boolean emEstoque) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.emEstoque = emEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(Boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
