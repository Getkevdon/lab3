package com.example.springlab3.repository;

import com.example.springlab3.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibraryId(Long libraryId);
    Long countByLibraryId(Long libraryid);
}
