package org.example;

import java.util.ArrayList;
import java.util.Optional;

public class InventoryManager {
    private ArrayList<BookCollection> bookCollectionArrayList = new ArrayList<>();

    public InventoryManager() {
        System.out.println("\nWelcome to Knowledge Archive platform: \n");
    }
    public void startMenu() {
        int option = 0;
        String message = "";
        do {
            message = "";
            option = Input.readInt(
                    "0. Exit\n" +
                            "1. Create a new collection\n" +
                            "2. Add books to a specific collection\n" +
                            "3. Add digital resources to complement a collection\n" +
                            "4. Show inventory\n" +
                            "5. Remove inventory resources from a collection\n" +
                            "Choose an option: ");

            switch (option) {
                case 0:
                    message = "The Knowledge Archive is closing...";
                    break;
                case 1:
                    message = createANewCollection();
                    break;
                case 2:
                    message = addBookToCollection();
                    break;
                case 3:
                    message = addDigitalResource();
                    break;
                case 4:
                    message = showInventory();
                    break;
                case 5:
//                    message = removeResource();
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }

    private String createANewCollection() {
        String newCollectionName = Input.readString("Insert a name for the book collection: ");

        if (collectionAlreadyExists(newCollectionName)) {
            System.out.println("Collection '" + newCollectionName + "' already exists.");
            startMenu();
        }

        int newCollectionAccessValue = Input.readInt("Choose a level of access for the new collection (1. PUBLIC, 2. PRIVATE, 3. RESTRICTED): ");
        if (newCollectionAccessValue > 3 || newCollectionAccessValue < 1) {
            System.out.println("Level does not exist. Try again.");
            newCollectionAccessValue = Input.readInt("Choose a level of access for the new collection (1. PUBLIC, 2. PRIVATE, 3. RESTRICTED): ");
        }
        AccessLevel newCollectionAccess = AccessLevel.findByValue(newCollectionAccessValue);
        BookCollection romanceCollectionBooks = new BookCollection(newCollectionName, newCollectionAccess);
        bookCollectionArrayList.add(romanceCollectionBooks);
        System.out.println("\nAll BookCollection: \n" + bookCollectionArrayList.toString() + "\n");
        return "New Collection named '" + romanceCollectionBooks.getName() + "' with access level '" + newCollectionAccess.toString().toLowerCase() + "' created successfully! \n";
    }

    private boolean collectionAlreadyExists(String collectionName) {
        Optional<BookCollection> bookCollection = bookCollectionArrayList.stream()
                .filter(d -> d.getName().equalsIgnoreCase(collectionName))
                .findFirst();
        if (!bookCollection.isEmpty()) {
            return true;
        }
        return false;
    }

    private String addBookToCollection() {
        String newBookName = Input.readString("Insert a name of the book: ");
        double bookPrice = Input.readDouble("Insert the book price in Euros: ");
        int estimatedTimeInSeconds = Input.readInt("Insert the book estimated reading time in seconds: ");
        int bookCategoryValue = Input.readInt("Choose a book category for book (1. Romance, 2. Fiction, 3. Biography, 4. History): ");
        if (bookCategoryValue > 5 || bookCategoryValue < 1) {
            System.out.println("Book category does not exist. Try again.");
            bookCategoryValue = Input.readInt("Choose a book category for book (1. Romance, 2. Fiction, 3. Biography, 4. History): ");
        }
        BookCategory bookCategory = BookCategory.findByValue(bookCategoryValue);
        Book newBook = new Book(newBookName, bookPrice, estimatedTimeInSeconds, bookCategory);

        for (int i = 0; i <= (bookCollectionArrayList.size() - 1); i++) {
            System.out.println((i + 1) + ". " + bookCollectionArrayList.get(i).getName());
        }

        int bookCollectionOption = Input.readInt("Choose an existing book collection: ");
        BookCollection bookCollection = bookCollectionArrayList.get(bookCollectionOption - 1);
        bookCollection.addBookToCollection(newBook);
        String bookCollectionName = bookCollection.getName();
        return "Book named: " + newBookName + "of category: " + bookCategory + " added successfully to collection: " + bookCollectionName;
    }

    private String addDigitalResource() {
        String newDigitalResourceName = Input.readString("Insert a name of the Digital Resource: ");
        double digitalResourcePrice = Input.readDouble("Insert the Digital Resource price in Euros: ");
        int digitalFormatValue = Input.readInt("Choose a digital format (1. Video, 2. Audio, 3. PDF): ");
        if (digitalFormatValue > 3 || digitalFormatValue < 1) {
            System.out.println("Digital Resource does not exist. Try again.");
            digitalFormatValue = Input.readInt("Choose a digital format (1. Video, 2. Audio, 3. PDF): ");
        }
        DigitalFormat digitalFormat = DigitalFormat.findByValue(digitalFormatValue);
        DigitalResource newDigitalResource = new DigitalResource(newDigitalResourceName, digitalResourcePrice, digitalFormat);

        for (int i = 0; i <= (bookCollectionArrayList.size() - 1); i++) {
            System.out.println((i + 1) + ". " + bookCollectionArrayList.get(i).getName());
        }

        int bookCollectionOption = Input.readInt("Choose an existing book collection: ");
        BookCollection bookCollection = bookCollectionArrayList.get(bookCollectionOption - 1);
        String bookCollectionName = bookCollection.getName();
        bookCollection.addDigitalResourceToCollection(newDigitalResource);
        return "Digital Resouce: " + newDigitalResourceName + " with format: " + digitalFormat + " added successfully to collection: " + bookCollectionName + "\n";

    }

    private String showInventory() {
        // Mostrar el inventario actualizado, incluyendo cantidades disponibles y valor total
        for (int i = 0; i <= (bookCollectionArrayList.size() - 1); i++) {
            System.out.println((i + 1) + ". " + bookCollectionArrayList.get(i).getName());
        }

        return "";
    }

    public double calculateTotalValueInEuros() {
        return 0;
    }
}


