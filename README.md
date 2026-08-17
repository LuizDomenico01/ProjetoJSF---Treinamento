# Sistema de Cadastro de Produtos - JSF & Hibernate

Aplicação web Full-Stack focada no gerenciamento de Produtos e Pessoas, construída com arquitetura Java EE.

## Tecnologias e Ferramentas Utilizadas

O ecossistema do projeto foi configurado através do **Maven**.

**Back-End:**
*   **Java 21:** Linguagem principal do projeto.
*   **Hibernate Core / JPA:** Framework ORM para mapeamento objeto-relacional.
*   **MySQL Server 8.0.46:** Banco de dados relacional.

**Front-End:**
*   **JSF:** Framework para construção de interfaces de usuário baseadas em componentes.
*   **PrimeFaces:** Biblioteca de componentes de UI avançados e responsivos para JSF.

**Testes:**
*   **JUnit 5 (Jupiter):** Motor para execução da suíte de testes unitários.
*   **Mockito (5.5.0):** Framework de mock para simulação de dependências (ex: isolamento da camada DAO) e verificação de comportamentos.

**Servidor de Aplicação:**
*   **Apache Tomcat 9.0.120 :** (https://tomcat.apache.org/)

---

## Estrutura do Projeto

```text
src/
 ├── main/
 │   ├── java/br/com/tcs/treinamento/
 │   │   ├── bean/       # ManagedBeans (Controladores de tela JSF)
 │   │   ├── dao/        # Classes de acesso direto ao banco de dados
 │   │   ├── entity/     # Entidades JPA (Produto, Pessoa)
 │   │   ├── model/      # Objetos de Transferência de Dados (VO)
 │   │   └── service/    # Regras de Negócio
 │   ├── resources/
 │   │   └── META-INF/
 │   │       └── persistence.xml # Configurações de conexão do Hibernate
 │   └── webapp/         # Páginas (.xhtml) e recursos estáticos do frontend
 └── test/
     └── java/br/com/tcs/treinamento/service/
         └── produto/
             └── ProdutoServiceImplTest.java # Suíte de testes automatizados
```

---

*Atenção: O projeto utiliza `hibernate.hbm2ddl.auto = update`, portanto as tabelas serão sincronizadas automaticamente durante a inicialização.*

**URL de Acesso:** `http://localhost:8080/tcs-jsf-treinamento`
