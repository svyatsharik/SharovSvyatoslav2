package ru.mts.Homework_MTS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mts.Homework_MTS.Book;
import ru.mts.Homework_MTS.BookRepository;

import java.util.List;
@Controller
public class BookViewController {
    private final BookRepository bookRepository;

    public BookViewController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }
}
