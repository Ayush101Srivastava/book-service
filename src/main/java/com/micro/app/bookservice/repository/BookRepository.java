package com.micro.app.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.app.bookservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
