package com.GustavoSilvDev.literalura.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GustavoSilvDev.literalura.model.Book;
import com.GustavoSilvDev.literalura.model.Languages;
import com.GustavoSilvDev.literalura.model.Person;
import com.GustavoSilvDev.literalura.repository.BookRepository;
import com.GustavoSilvDev.literalura.repository.PersonRepository;
import com.GustavoSilvDev.literalura.service.GetBook;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Principal {
    Scanner sc = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    private List<Person> authors = new ArrayList<>();

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    public Principal(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }


    String firstMenu = """
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em determinado idioma
                6 - Listar Top 10 livros mais baixados
                7 - Buscar autor
                8 - Verificar percentual de livros por idioma
                
                0 - Sair
            """;
    String initial = "https://gutendex.com/books/?search=";


    public void exibirMenu() {
        int option = -1;
        while (option != 0) {

            System.out.println(firstMenu);
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("");
            }
            sc.nextLine();
            switch (option) {
                case 1:
                    buscarLivros();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosAno();
                    break;
                case 5:
                    listarLivrosIdioma();
                    break;
                case 6:
                    listarTop10Livros();
                    break;
                case 7:
                    buscarAutor();
                    break;
                case 8:
                    listarPercentualIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        }
    }

    private void buscarLivros() {
        System.out.println("Deseja o nome do livro que deseja pesquisar: ");
        String url = initial + sc.nextLine().replace(" ", "%20");
        GetBook getter = new GetBook(bookRepository, personRepository);
        getter.getDataBook(url);
    }


    private void listarLivros() {
        books = bookRepository.findAll();
        books.stream().forEach(System.out::println);
    }

    private void listarAutores() {
        authors = personRepository.findAll();
        authors.stream().forEach(System.out::println);
    }

    private void listarAutoresVivosAno() {
        authors = personRepository.findAll();
        System.out.println("Digite o ano para verificar os autores vivos:");
        int year = sc.nextInt();
        sc.nextLine();
        personRepository.findLivingAuthorsInYear(year).stream().forEach(System.out::println);
    }

    private void listarLivrosIdioma() {
        System.out.println("Digite o idioma desejado:");
        String idioma = sc.nextLine().toLowerCase();
        Languages lang = Languages.fromIdioma(idioma);

        List<Book> allBooks = bookRepository.findAll();
//        for (Book book : allBooks) {
//            System.out.println("Book: " + book.getTitle() + ", Languages: " + book.getLanguages());
//        }
        List<Book> livrosIdioma = bookRepository.findBooksByLanguage(lang);
        System.out.println("Livros disponíveis no idioma " + idioma);
        livrosIdioma.forEach(System.out::println);
    }

    private void listarTop10Livros() {
        GetBook getter = new GetBook(bookRepository, personRepository);
        getter.getTop(initial);
    }

    private void buscarAutor() {
        System.out.println("Digite APENAS o nome OU sobrenome do autor que deseja buscar informações: ");
        String autor = sc.nextLine().replace(" ", "%20");
        GetBook getter = new GetBook(bookRepository, personRepository);
        getter.getAuthor(autor);
    }

    private void listarPercentualIdioma() {
        books = bookRepository.findAll();
        Map<String, DoubleSummaryStatistics> percentualPorIdioma = books.stream()
                .collect(Collectors.groupingBy(Book::getLanguages, Collectors.summarizingDouble(book -> 1)));

        long totalDeLivros = books.size();
        System.out.println("Percentual de livros no banco de dados em determinados idiomas: ");
        percentualPorIdioma.forEach((language, stats) -> {
            double porcentagem = ((double) stats.getCount() / totalDeLivros) * 100;
            System.out.println(Languages.getIdiomaFromCode(language) + ": " + porcentagem + "%\n");
        });
    }
}





