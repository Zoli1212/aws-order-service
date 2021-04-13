package com.javatechie.springbootawsfull.repository;

import com.javatechie.springbootawsfull.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByName(String bookname);
}
