package br.com.tcs.treinamento.dao;

import br.com.tcs.treinamento.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;
    private EntityManagerFactory emf;

    public ProdutoDAO(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("myPU");
        }
        em = emf.createEntityManager();
    }

    public void cadastrarProduto(Produto produtoEntity){
      try{
          em.getTransaction().begin();
          if(produtoEntity.getId() == null){
              em.persist(produtoEntity);
          }else{
              em.merge(produtoEntity);
          }
          em.getTransaction().commit();
      } catch (Exception e){
          if(em.getTransaction().isActive()){
              em.getTransaction().rollback();
          }
          throw e;
      }
    }

    public void excluirProduto (Produto produtoEntity) {
        try {
            em.getTransaction().begin();
            produtoEntity.setAtivo(false);
            em.merge(produtoEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public List<Produto> listarProdutos(){
        return em.createQuery("select p from Produto p where p.ativo = true", Produto.class).getResultList();
    }
}
