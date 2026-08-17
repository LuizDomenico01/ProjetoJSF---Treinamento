package br.com.tcs.treinamento.service.produto;

import br.com.tcs.treinamento.dao.ProdutoDAO;
import br.com.tcs.treinamento.entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceImplTest {

    @Mock
    private ProdutoDAO produtoDAO;

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Test
    //@Tag("sucesso")
    public void deveListarProdutosComSucesso() {
        // arranjar dados
        Produto p1 = new Produto(1L, "Notebook", 10, 3500.0, true);
        Produto p2 = new Produto(2L, "Mouse", 50, 120.0, true);

        Mockito.when(produtoDAO.listarProdutos()).thenReturn(Arrays.asList(p1, p2));

        // ação
        List<Produto> resultado = produtoService.listarProdutos();

        // validações
        Assertions.assertNotNull(resultado, "A lista de produtos não deveria ser nula");
        Assertions.assertEquals(2, resultado.size(), "A lista deveria conter 2 produtos");
        Assertions.assertEquals("Notebook", resultado.get(0).getNomeProduto());

        // garantir chamada corre para o método do banco de dados;
        Mockito.verify(produtoDAO, Mockito.times(1)).listarProdutos();
    }

    @Test
    //@Tag("sucesso")
    public void deveCadastrarProdutoComSucesso() {
        Produto novoProduto = new Produto(null, "Teclado Mecânico", 15, 450.0, true);

        produtoService.cadastrarProduto(novoProduto);
        // não tem assert por conta que o método cadastrarProduto() é um void;
        Mockito.verify(produtoDAO, Mockito.times(1)).cadastrarProduto(novoProduto);
    }

    @Test
    public void deveAcionarExclusaoDeProdutoComSucesso() {
        Produto produtoParaExcluir = new Produto(5L, "Cadeira Ergonômica", 5, 1200.0, true);
        produtoService.excluirProduto(produtoParaExcluir);

        Mockito.verify(produtoDAO, Mockito.times(1)).excluirProduto(produtoParaExcluir);
    }


    // testes com falhas

    @Test
    public void deveFalharPorIncompatibilidadeDeValores() {
        Produto p1 = new Produto(1L, "Monitor", 5, 800.0, true);
        Mockito.when(produtoDAO.listarProdutos()).thenReturn(Arrays.asList(p1));

        List<Produto> resultado = produtoService.listarProdutos();

        Assertions.assertEquals(10, resultado.size(), "Simulando erro de tamanho da lista");
    }

    @Test
    public void deveFalharAoVerificarQuantidadeDeSalvamentos() {
        Produto produto = new Produto(null, "Headset Gamer", 10, 250.0, true);
        produtoService.cadastrarProduto(produto);

        Mockito.verify(produtoDAO, Mockito.times(2)).cadastrarProduto(produto);
    }

    @Test
    public void deveFalharAoCadastrarProdutoSemNome() {
        Produto produtoSemNome = new Produto(null, null, 15, 450.0, true);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            produtoService.cadastrarProduto(produtoSemNome);
        }, "Cadastro inválido de um produto sem nome");
    }
}