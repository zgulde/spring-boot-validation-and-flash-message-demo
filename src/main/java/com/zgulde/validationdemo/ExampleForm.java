package com.zgulde.validationdemo;

import javax.validation.constraints.NotBlank;

public class ExampleForm {

    @NotBlank(message = "Name can't be blank!")
    private String name;

    public String getName() {
        return name;
    }

    public ExampleForm setName(String name) {
        this.name = name;
        return this;
    }
}
