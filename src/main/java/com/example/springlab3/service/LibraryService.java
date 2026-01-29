package com.example.springlab3.service;

import com.example.springlab3.domain.Library;
import com.example.springlab3.repository.LibraryRepository;

import java.util.List;

public class LibraryService {
    private final LibraryRepository repo;
    public LibraryService(LibraryRepository repo){
        this.repo = repo;
    }


    public List<Library> getAllLibraries(){
        return repo.findAll();
    }

    public Library getLibraryById(Long id){
        return repo.getReferenceById(id);
    }

    public Library createLibrary(Library library){
        return repo.save(library);
    }

    public void deleteLibrary(Long id){
        repo.deleteById(id);
    }



}
