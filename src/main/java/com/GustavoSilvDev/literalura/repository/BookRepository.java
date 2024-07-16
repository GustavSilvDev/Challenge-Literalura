package com.GustavoSilvDev.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GustavoSilvDev.literalura.model.Book;
import com.GustavoSilvDev.literalura.model.Languages;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);



    @Query("SELECT b FROM Book b WHERE %:language% MEMBER OF b.languages")
    List<Book> findBooksByLanguage(@Param("language") Languages language);
}
