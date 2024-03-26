package ru.mts.Homework_MTS.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Book title have to be filled")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany(mappedBy = "books")
    private Set<Tag> tags = new HashSet<>();
    protected Book(){
    }

    public Book(Long id, String title, Long authorID) {
        this.id = id;
        this.title = title;
        this.author = new Author(authorID);
    }


    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(tags, book.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, tags);
    }

    public void createTag(Tag tag) {
        this.tags.add(tag);
    }

    public void deleteTag(Tag tag) {
        this.tags.remove(tag);
    }

}
