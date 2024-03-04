package ru.mts.Homework_MTS.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.Homework_MTS.Book;
import ru.mts.Homework_MTS.BookRepository;
import ru.mts.Homework_MTS.dto.BookRequestToCreate;
import ru.mts.Homework_MTS.dto.BookRequestToUpdate;

import java.util.List;

import static java.util.Objects.requireNonNullElse;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> bookTable() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@NotNull @PathVariable("id") Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@NotNull @PathVariable Long id,
                           @NotNull @RequestBody @Valid BookRequestToUpdate request) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        return bookRepository.save(book);
    }

    @PostMapping("/books")
    public Book createBook(@NotNull @RequestBody @Valid BookRequestToCreate request) {
        Book course = new Book(request.getAuthor(), request.getTitle(), request.getTags());
        return bookRepository.save(course);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@NotNull @PathVariable Long id) {
        return bookRepository.deleteById(id);
    }

    @GetMapping("/books/filter")
    public List<Book> getBooksByTag(@RequestParam(name = "tag", required = false) String tag) {
        return bookRepository.findBooksByTag(requireNonNullElse(tag, ""));
    }

}
