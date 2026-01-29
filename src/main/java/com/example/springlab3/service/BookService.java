package com.example.springlab3.service;

import com.example.springlab3.domain.Book;
import com.example.springlab3.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo){
        this.repo = repo;
    }

    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    public Book createBook(Long libraryId, Book book){
        return repo.save(book);
    }

    public List<Book> getBookByLibrary(Long libraryId){
        return (List<Book>) repo.getReferenceById(libraryId);
    }

}
