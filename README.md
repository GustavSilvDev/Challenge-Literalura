# Livraria

Livraria é uma aplicação desenvolvida em Java 17 que permite aos usuários buscar informações sobre livros e autores utilizando a API Gutendex. Os dados são armazenados em um banco de dados PostgreSQL. Este projeto foi desenvolvido utilizando a IDE IntelliJ IDEA e a Java Persistence API (JPA) para gerenciamento de dados.

## Funcionalidades

A aplicação oferece as seguintes funcionalidades:

- **Buscar livro pelo título:** Permite ao usuário buscar um livro pelo título e armazená-lo no banco de dados.
- **Listar livros registrados:** Lista todos os livros registrados no banco de dados.
- **Listar autores registrados:** Lista todos os autores registrados no banco de dados.
- **Listar autores vivos em um determinado ano:** Lista os autores que estavam vivos em um ano específico e que foram registrados no banco de dados.
- **Listar livros em determinado idioma:** Lista os livros disponíveis no banco de dados em um idioma específico.
- **Listar Top 10 livros mais baixados:** Mostra os 10 livros mais baixados no Gutendex.
- **Buscar autor:** Permite ao usuário buscar informações sobre um autor. Caso o autor não seja encontrado no banco de dados, será realizada uma busca de um livro de sua autoria que será inserido no banco de dados.
- **Verificar percentual de livros por idioma:** Mostra o percentual de livros no banco de dados em cada idioma.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- JPA (Java Persistence API)
- PostgreSQL
- IntelliJ IDEA

## Instalação

Para executar a aplicação localmente, siga estas etapas:

1. Clone este repositório:

    ```sh
    git clone https://github.com/GustavSilvDev/Literalura.git
    ```

2. Certifique-se de ter o Java JDK 17 ou superior instalado.
3. Importe o projeto na sua IDE IntelliJ IDEA.
4. Configure o PostgreSQL e atualize as configurações no arquivo `application.properties`.
5. Execute a classe `LivrariaApplication.java`.

## Uso

Após iniciar a aplicação, você será apresentado a um menu interativo. Basta selecionar a opção desejada e seguir as instruções.

## Contribuição

Sinta-se à vontade para contribuir com melhorias e correções para este projeto. Você pode fazer isso através de pull requests e issues no GitHub.

 
