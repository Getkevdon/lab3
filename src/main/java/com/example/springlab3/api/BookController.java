package com.example.springlab3.api;

import com.example.springlab3.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public  BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/libraries/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBookToLibrary(@PathVariable Long id, @Validated @RequestBody Book book){
        return bookService.createBook(id, book);
    }

}
