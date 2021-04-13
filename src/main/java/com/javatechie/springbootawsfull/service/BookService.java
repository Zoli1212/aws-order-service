package com.javatechie.springbootawsfull.service;


import com.javatechie.springbootawsfull.entity.Book;
import com.javatechie.springbootawsfull.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findByBookName(String bookname){

        return bookRepository.findByName(bookname).orElse(null);


    }
}
