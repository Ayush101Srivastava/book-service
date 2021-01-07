package com.micro.app.bookservice.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.micro.app.bookservice.entity.Book;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BookController {

	private JpaRepository<Book, Long> bookRepository;

	public BookController(JpaRepository<Book, Long> bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Book> listAllBooks() {
		return bookRepository.findAll();
	}

	@GetMapping(path = "/{book_id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Book listBookById(@PathVariable(name = "book_id") Long id) {
		return bookRepository.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody @Validated Book book) {
		return bookRepository.saveAndFlush(book);
		
	}
	
	@DeleteMapping(path = "/{book_id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteBook(@PathVariable(name = "book_id") Long id) {
		bookRepository.deleteById(id);
	}
	
	@PutMapping(path = "/{book_id}")
	@ResponseStatus(code = HttpStatus.RESET_CONTENT)
	public void updateBook(@PathVariable(name = "book_id") Long id,@RequestBody @Validated Book book) {
		bookRepository.saveAndFlush(book);
	}
}
