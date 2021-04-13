package com.javatechie.springbootawsfull.controller;


import com.javatechie.springbootawsfull.entity.Book;
import com.javatechie.springbootawsfull.repository.BookRepository;
import com.javatechie.springbootawsfull.service.BookService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookservice;
    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        if(bookservice.findByBookName(book.getName())!=null)
        {

            return new ResponseEntity<>(HttpStatus.CONFLICT);


        }

        return new ResponseEntity<>(bookRepository.save(book),HttpStatus.CREATED );


    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){

        return ResponseEntity.ok(bookRepository.findAll());
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow( () -> new Exception ("Book not found") );
        return book;
    }





}
