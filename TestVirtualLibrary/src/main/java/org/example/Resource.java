package org.example;

import java.util.UUID;

public class Resource {
    private String id = UUID.randomUUID().toString();
    private double price;
    private String name;

    public Resource(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
