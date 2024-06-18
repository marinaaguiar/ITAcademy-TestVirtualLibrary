package org.example;

public enum BookCategory {
    ROMANCE("romance", 1),
    FICTION("fiction", 2),
    BIOGRAPHY("biography", 3),
    HISTORY("history", 4);

    private final int value;
    private final String string;

    BookCategory(String string, int value) {
        this.value = value;
        this.string = string;
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return string;
    }

    public static BookCategory findByValue(int value) {
        for (BookCategory category : values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        return null;
    }


}
