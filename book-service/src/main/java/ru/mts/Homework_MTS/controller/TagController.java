package ru.mts.Homework_MTS.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.Homework_MTS.Entity.Book;
import ru.mts.Homework_MTS.Entity.Tag;
import ru.mts.Homework_MTS.Repository.BookRepository;
import ru.mts.Homework_MTS.Repository.TagRepository;
import ru.mts.Homework_MTS.dto.BookTagRequestToCreate;
import ru.mts.Homework_MTS.dto.BookTagRequestToUpdate;
import ru.mts.Homework_MTS.dto.TagRequestToCreate;
import ru.mts.Homework_MTS.dto.TagRequestToUpdate;


@RestController
@RequestMapping("/api")
@Validated
public class TagController {
    private final TagRepository tagRepository;
    private final BookRepository bookRepository;

    public TagController(TagRepository tagRepository, BookRepository bookRepository) {
        this.tagRepository = tagRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/tag")
    public Tag createTag(@NotNull @RequestBody @Valid TagRequestToCreate request) {
        Tag tag = new Tag(request.getName());
        return tagRepository.save(tag);
    }

    @PutMapping("/tag/{id}")
    public Tag updateTag(@NotNull @PathVariable Long id,
                            @NotNull @RequestBody @Valid TagRequestToUpdate request) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        Tag newTag = new Tag(tag.getId(), request.getName());
        return tagRepository.save(newTag);
    }

    @DeleteMapping("/tag/{id}")
    public void deleteTag(@NotNull @PathVariable Long id) {
        tagRepository.deleteById(id);
    }

    @PutMapping("/book/tag")
    @Transactional
    public void createBook(@NotNull @RequestBody @Valid BookTagRequestToCreate request) {
        Tag tag = tagRepository.findById(request.getTagID()).orElseThrow();
        Book book = bookRepository.findById(request.getBookID()).orElseThrow();
        tag.createBook(book);
    }

    @DeleteMapping("/book/tag")
    @Transactional
    public void deleteBook(@NotNull @RequestBody @Valid BookTagRequestToUpdate request) {
        Tag tag = tagRepository.findById(request.getTagID()).orElseThrow();
        Book book = bookRepository.findById(request.getBookID()).orElseThrow();
        tag.deleteBook(book);
    }
}
