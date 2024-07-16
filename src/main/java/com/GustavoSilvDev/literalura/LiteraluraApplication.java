package com.GustavoSilvDev.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GustavoSilvDev.literalura.principal.Principal;
import com.GustavoSilvDev.literalura.repository.BookRepository;
import com.GustavoSilvDev.literalura.repository.PersonRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(bookRepository, personRepository);
		principal.exibirMenu();
	}
}
