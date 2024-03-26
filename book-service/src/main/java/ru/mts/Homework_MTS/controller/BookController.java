package ru.mts.Homework_MTS.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.Homework_MTS.Entity.Author;
import ru.mts.Homework_MTS.Entity.Book;
import ru.mts.Homework_MTS.Repository.BookRepository;
import ru.mts.Homework_MTS.dto.BookRequestToCreate;
import ru.mts.Homework_MTS.dto.BookRequestToUpdate;


@RestController
@RequestMapping("/api")
@Validated
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @PostMapping("/book")
    public Book createBook(@NotNull @RequestBody @Valid BookRequestToCreate request) {
        System.out.println(request.getAuthorID());
        Book book = new Book(request.getTitle());
        book.setAuthor(new Author(request.getAuthorID()));
        return bookRepository.save(book);
    }


    @PutMapping("/book/{id}")
    public Book updateBook(@NotNull @PathVariable Long id,
                           @NotNull @RequestBody @Valid BookRequestToUpdate request) {
        Book book = bookRepository.findById(id).orElseThrow();
        Book newBook = new Book(book.getId(), request.getTitle(), request.getAuthorID());
        return bookRepository.save(newBook);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@NotNull @PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
