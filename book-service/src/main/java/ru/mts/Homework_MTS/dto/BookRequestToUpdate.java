package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class BookRequestToUpdate {
    public BookRequestToUpdate(String author, String title, Set<String> tags) {
        this.author = author;
        this.title = title;
        this.tags = tags;
    }

    @NotNull
    private String author;
    @NotNull
    private String title;
    @NotNull
    Set<String> tags;

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
