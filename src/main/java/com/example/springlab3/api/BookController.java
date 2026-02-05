package com.example.springlab3.api;

import com.example.springlab3.domain.Book;
import com.example.springlab3.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public List<com.example.springlab3.domain.Book> getBookByLibrary(@PathVariable Long id) {
        return bookService.getBookByLibrary(id);
    }

    @PostMapping("/libraries/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    public com.example.springlab3.domain.Book addBookToLibrary(@PathVariable Long id, @Validated @RequestBody com.example.springlab3.domain.Book book){
        return bookService.createBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
