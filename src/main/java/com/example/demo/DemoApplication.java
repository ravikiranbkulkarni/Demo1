package com.example.demo;

import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.*;



@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(AuthorRepository authorrepository, BookRepository bookrepository) {
		return (args) -> {
			// save a couple of Authors
			Author auth=new Author();
			auth.setFirstName("Ravi");
			auth.setLastName("Kulkarni");
			authorrepository.save(auth);

			// fetch all customers
			log.info("Authors found with findAll():");
			log.info("-------------------------------");
			for (Author author : authorrepository.findAll()) {
				log.info(author.toString());
			}

			log.info("");

			// fetch an individual Author by ID

			Author author = authorrepository.findOne(1L);
			log.info("Author found with findOne(1L):");
			log.info("--------------------------------");
			log.info(author.toString());
			log.info("");



			// fetch Author by last name

			log.info("Auther found with findByLastName('Ravi'):");
			log.info("--------------------------------------------");
			for (Author Ravi : authorrepository.findByFirstNameOrderByLastNameDesc("Ravi")) {
				log.info(Ravi.toString());
			}

			log.info("");


			// save a couple of BookCategory
			bookrepository.save(new Book("Test",auth));
			log.info("One book added");
			bookrepository.save(new Book("Test1",auth));
			log.info("Two book added");

			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : bookrepository.findAll()) {
				log.info(book.toString());
			}

		};

	}

}
