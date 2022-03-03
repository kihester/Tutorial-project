package com.netcompany.bookstore.model;

import java.util.Arrays;
import java.util.Optional;

public enum Genre {
    ADVENTURE("Adventure"),
    SCIFI("Scifi"),
    FICTION("Fiction");

    private String text;

    Genre(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<Genre> fromText(String text) {
        return Arrays.stream(values())
                .filter(bl -> bl.text.equalsIgnoreCase(text))
                .findFirst();
    }

}
