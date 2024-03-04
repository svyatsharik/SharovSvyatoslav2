package ru.mts.Homework_MTS;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Book save(Book course);

    Book deleteById(Long id);
    List<Book> findBooksByTag(String prefix);
}
