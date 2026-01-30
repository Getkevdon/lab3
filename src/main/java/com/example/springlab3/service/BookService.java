package com.example.springlab3.service;

import com.example.springlab3.domain.Book;
import com.example.springlab3.repository.BookRepository;
import com.example.springlab3.repository.LibraryRepository;

import java.util.List;

public class BookService {
    private final BookRepository repo;
    private final LibraryRepository libRepo;

    public BookService(BookRepository repo, LibraryRepository libRepo) {
        this.repo = repo;
        this.libRepo = libRepo;

    }

    public List<java.awt.print.Book> getAllBooks(BookRepository ){
        return repo.findAll();
    }

    public Book createBook(Long libraryId, Book book){
        return repo.save(book);
    }

    public List<Book> getBookByLibrary(Long libraryId){
        return (List<Book>) repo.getReferenceById(libraryId);
    }

}
