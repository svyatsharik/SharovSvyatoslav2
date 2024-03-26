package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class TagRequestToUpdate {
    @NotNull
    private String name;
    public TagRequestToUpdate() {}

    public TagRequestToUpdate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
