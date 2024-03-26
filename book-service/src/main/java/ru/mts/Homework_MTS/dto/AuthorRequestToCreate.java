package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class AuthorRequestToCreate {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    public AuthorRequestToCreate() {}

    public AuthorRequestToCreate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
