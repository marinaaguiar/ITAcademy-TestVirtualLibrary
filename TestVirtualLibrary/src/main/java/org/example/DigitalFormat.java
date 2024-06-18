package org.example;

public enum DigitalFormat {
    VIDEO(1), AUDIO(2), PDF(3);

    private final int value;

    DigitalFormat(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DigitalFormat findByValue(int value) {
        for (DigitalFormat format : values()) {
            if (format.getValue() == value) {
                return format;
            }
        }
        return null;
    }
}
