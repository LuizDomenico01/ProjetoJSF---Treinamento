package br.com.tcs.treinamento.entity;

import javax.persistence.*;

@Entity
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeProduto;

    @Column
    private Integer quantidade;

    @Column
    private Double preco;

    @Column
    private Boolean emEstoque;

    @Column
    private Boolean ativo = true;

    public Produto(){}

    public Produto(Long id, String nomeProduto, Integer quantidade, Double preco, Boolean emEstoque) {
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
