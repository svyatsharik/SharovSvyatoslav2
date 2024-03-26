package ru.mts.Homework_MTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.Homework_MTS.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
