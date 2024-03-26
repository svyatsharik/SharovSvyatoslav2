package ru.mts.Homework_MTS.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Tag name have to be filled")
    private String name;

    @ManyToMany(fetch = LAZY, cascade = PERSIST)
    @JoinTable(
            name = "tag_book",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    protected Tag(){

    }
    public Tag(String name) {
        this.name = name;
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(name, tag.name) && Objects.equals(books, tag.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }

    public void createBook(Book book) {
        this.books.add(book);
    }

    public void deleteBook(Book book) {
        this.books.remove(book);
    }
}
