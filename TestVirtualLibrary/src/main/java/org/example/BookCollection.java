package org.example;

import java.util.ArrayList;
import java.util.UUID;

public class BookCollection {
    private String id = UUID.randomUUID().toString();
    private String name;
    private AccessLevel accessLevel;
    private double totalValueInEuros;
    private ArrayList<Book> bookArrayList = new ArrayList<>();
    private ArrayList<DigitalResource> digitalResourceArrayList = new ArrayList<>();

    public BookCollection(String name, AccessLevel accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public void addBookToCollection(Book book) {
        bookArrayList.add(book);
    }

    public void addDigitalResourceToCollection(DigitalResource digitalResource) {
        digitalResourceArrayList.add(digitalResource);
    }

    @Override
    public String toString() {
        return "BookCollection{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}
