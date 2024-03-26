package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class BookTagRequestToCreate {
    @NotNull
    private Long bookID;

    @NotNull
    private Long tagID;

    public BookTagRequestToCreate() {}

    public BookTagRequestToCreate(Long bookID, Long tagID) {
        this.bookID = bookID;
        this.tagID = tagID;
    }

    public Long getBookID() {
        return bookID;
    }

    public Long getTagID() {
        return tagID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setTagID(Long tagID) {
        this.tagID = tagID;
    }
}
