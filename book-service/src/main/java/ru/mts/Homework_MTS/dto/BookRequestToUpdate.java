package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class BookRequestToUpdate {

    @NotNull
    private Long authorID;
    @NotNull
    private String title;
    public BookRequestToUpdate() {}
    public BookRequestToUpdate(Long authorID, String title) {
        this.authorID = authorID;
        this.title = title;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
