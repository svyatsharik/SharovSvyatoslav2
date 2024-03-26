package ru.mts.Homework_MTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.Homework_MTS.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {}
