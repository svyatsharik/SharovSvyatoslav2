package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class BookRequestToCreate {
    @NotNull
    private Long authorID;
    @NotNull
    private String title;
    public BookRequestToCreate() {}

    public BookRequestToCreate(Long authorID, String title) {
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
        this.authorID = this.authorID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
