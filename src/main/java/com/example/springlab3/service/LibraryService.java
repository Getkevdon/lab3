package com.example.springlab3.service;

import com.example.springlab3.domain.Library;
import com.example.springlab3.repository.BookRepository;
import com.example.springlab3.repository.LibraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository repo;
    private final BookRepository bookrepo;
    public LibraryService(LibraryRepository repo, BookRepository bookrepo){
        this.repo = repo;
        this.bookrepo = bookrepo;
    }

    public List<Library> getAllLibraries(){
        return repo.findAll();
    }

    public Library getLibraryById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Library not found with id " + id));
    }

    public Library createLibrary(Library library){
        return repo.save(library);
    }

    @Transactional
    public void deleteLibrary(Long id){
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Library not found with id " + id);
        }

        long bookCount = bookrepo.countByLibraryId(id);
        if (bookCount > 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete library " + id + " because it still has " + bookCount + " book(s).");
        }
        repo.deleteById(id);
    }



}
