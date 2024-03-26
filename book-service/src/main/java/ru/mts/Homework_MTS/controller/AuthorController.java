package ru.mts.Homework_MTS.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.Homework_MTS.Entity.Author;
import ru.mts.Homework_MTS.Repository.AuthorRepository;
import ru.mts.Homework_MTS.dto.AuthorRequestToCreate;
import ru.mts.Homework_MTS.dto.AuthorRequestToUpdate;


@RestController
@RequestMapping("/api")
@Validated
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/author")
    public Author createAuthor(@NotNull @RequestBody @Valid AuthorRequestToCreate request) {
        Author author = new Author(request.getFirstName(), request.getLastName());
        return authorRepository.save(author);
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@NotNull @PathVariable Long id,
                           @NotNull @RequestBody @Valid AuthorRequestToUpdate request) {
        Author author = authorRepository.findById(id).orElseThrow();
        return authorRepository.save(new Author(author.getId(), request.getFirstName(), request.getLastName()));
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@NotNull @PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
