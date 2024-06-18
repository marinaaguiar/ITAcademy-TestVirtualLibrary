package org.example;

public enum AccessLevel {
    PUBLIC(1, "public"),
    PRIVATE(2, "private"),
    RESTRICTED(3, "restricted");

    private final String string;
    private final int value;

    AccessLevel(int value, String string) {
        this.string = string;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        return string;
    }

    public static AccessLevel findByValue(int value) {
        for (AccessLevel level : values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        return null;
    }
}
