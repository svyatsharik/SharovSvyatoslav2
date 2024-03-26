package ru.mts.Homework_MTS.dto;

import jakarta.validation.constraints.NotNull;

public class TagRequestToCreate {
    @NotNull
    private String name;
    public TagRequestToCreate() {}

    public TagRequestToCreate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
