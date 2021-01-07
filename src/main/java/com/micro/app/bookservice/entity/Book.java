package com.micro.app.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "BOOK")
@Data
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	@Size(min = 1)
	private String title;
	@Size(min = 1)
	private String author;
	@Size(min = 1)
	private String publication;

	public Book(@NonNull @Size(min = 1) String title, @Size(min = 1) String author, @Size(min = 1) String publication) {
		super();
		this.title = title;
		this.author = author;
		this.publication = publication;
	}

}
