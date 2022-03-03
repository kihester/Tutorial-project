package com.netcompany.bookstore.model;

import java.util.Arrays;
import java.util.Optional;

public enum Genre {
    ADVENTURE("Adventure"),
    SCIFI("Scifi"),
    FICTION("Fiction");

    private String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static Optional<Genre> fromText(String text) {
        return Arrays.stream(values())
                .filter(bl -> bl.displayName.equalsIgnoreCase(text))
                .findFirst();
    }

}
