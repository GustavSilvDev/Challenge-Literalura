# Literalura

A **Livraria** é uma aplicação desenvolvida em Java 17 que permite a busca e gerenciamento de informações sobre livros e autores, utilizando a API Gutendex para obter dados atualizados. Os dados são armazenados em um banco de dados PostgreSQL, e o gerenciamento é feito através da Java Persistence API (JPA). O projeto foi desenvolvido com a IDE IntelliJ IDEA.

## Recursos Principais

A aplicação oferece uma variedade de funcionalidades, incluindo:

- **Busca de Livro por Título:** Encontre e adicione livros ao banco de dados pelo título.
- **Exibição de Livros Registrados:** Visualize todos os livros que estão no banco de dados.
- **Listagem de Autores Registrados:** Veja todos os autores cadastrados na base de dados.
- **Autores Vivos por Ano:** Consulte quais autores estavam vivos em um ano específico e que foram registrados.
- **Livros por Idioma:** Filtre e liste livros disponíveis no banco de dados por idioma.
- **Top 10 Livros Mais Baixados:** Descubra os 10 livros mais baixados na API Gutendex.
- **Busca de Autor:** Procure informações sobre autores e, caso não estejam no banco de dados, adicione um livro de sua autoria.
- **Percentual de Livros por Idioma:** Veja a distribuição percentual dos livros no banco de dados por idioma.

## Tecnologias Empregadas

- **Java 17**: A linguagem de programação utilizada.
- **Spring Boot**: Framework para desenvolvimento de aplicações.
- **JPA (Java Persistence API)**: Para o gerenciamento e persistência de dados.
- **PostgreSQL**: Banco de dados utilizado para armazenar as informações.
- **IntelliJ IDEA**: IDE utilizada para o desenvolvimento do projeto.

## Como Configurar e Executar

Para configurar e rodar a aplicação localmente, siga os passos abaixo:

1. Clone o repositório para sua máquina:

    ```sh
    git clone https://github.com/GustavSilvDev/Literalura.git
    ```

2. Verifique se você possui o **Java JDK 17** ou superior instalado em sua máquina.
3. Importe o projeto para a IDE IntelliJ IDEA.
4. Configure o PostgreSQL e atualize as configurações necessárias no arquivo `application.properties`.
5. Execute a aplicação iniciando a classe `LivrariaApplication.java`.
