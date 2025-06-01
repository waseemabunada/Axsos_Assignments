package com.example.axsos.repositories;
import com.example.axsos.models.Book;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{  //<modelname,long>
    // this method retrieves all the books from the database
    List<Book> findAll();
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}

