package org.example;

public class Book extends Resource {
    private int estimatedReadingTimeInSeconds;
    private BookCategory bookCategory;

    public Book(String name, double price, int estimatedReadingTimeInSeconds, BookCategory bookCategory) {
        super(name, price);
        this.estimatedReadingTimeInSeconds = estimatedReadingTimeInSeconds;
        this.bookCategory = bookCategory;
    }
}
