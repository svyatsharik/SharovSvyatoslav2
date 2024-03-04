package ru.mts.Homework_MTS;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Book {
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

    private static final AtomicLong idGenerator = new AtomicLong(0);
    private Long id;
    private String author;
    private String title;
    private Set<String> tags;

    public Book(String author, String title, Set<String> tags) {
        this.id = generateID();
        this.author = author;
        this.title = title;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public static Long generateID() {
        return idGenerator.incrementAndGet();
    }
}
