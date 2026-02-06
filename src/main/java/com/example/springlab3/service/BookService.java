package com.example.springlab3.service;

import com.example.springlab3.domain.Book;
import com.example.springlab3.domain.Library;
import com.example.springlab3.repository.BookRepository;
import com.example.springlab3.repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class BookService {
    private final BookRepository bookrepo;
    private final LibraryRepository libRepo;

    public BookService(BookRepository repo, LibraryRepository libRepo) {
        this.bookrepo = repo;
        this.libRepo = libRepo;

    }

    public List<Book> getAllBooks(){
        return bookrepo.findAll();
    }

    public List<Book> getBookByLibrary(Long libraryId ){
        if (!libRepo.existsById(libraryId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Library not found with id " + libraryId);
        }
        return bookrepo.findByLibraryId(libraryId);
    }

    public Book createBook(Long libraryId, Book book) {
        Library library = libRepo.findById(libraryId)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Library not found with id " + libraryId
                        ));
        book.setLibrary(library);
        return bookrepo.save(book);
    }

    public void deleteBook(Long bookId) {
        if (!bookrepo.existsById(bookId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id " + bookId);
        }
        bookrepo.deleteById(bookId);
    }



}
