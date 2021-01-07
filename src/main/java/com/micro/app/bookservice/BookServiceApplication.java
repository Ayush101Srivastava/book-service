package com.micro.app.bookservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.micro.app.bookservice.entity.Book;
import com.micro.app.bookservice.repository.BookRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BookRepository repository) {
		String[][] data = { { "title1", "author1", "publication1" }, { "title2", "author2", "publication2" },
				{ "title3", "author3", "publication3" }, };

		return args -> {
			Stream.of(data).forEach(array -> {
				Book book = new Book(array[0], array[1], array[2]);
				repository.save(book);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}
