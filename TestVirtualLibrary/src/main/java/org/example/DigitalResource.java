package org.example;

public class DigitalResource extends Resource {
    private DigitalFormat digitalFormat;

    public DigitalResource(String name, double price, DigitalFormat digitalFormat) {
        super(name, price);
        this.digitalFormat = digitalFormat;
    }
}
