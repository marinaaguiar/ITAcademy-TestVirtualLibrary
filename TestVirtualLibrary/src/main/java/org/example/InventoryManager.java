package org.example;

import java.util.ArrayList;

public class InventoryManager {
    //    private ArrayList<Book> bookArrayList = new ArrayList<>();
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
//                    message = addDigitalResource();
                    break;
                case 4:
//                    message = showInventory();
                    break;
                case 5:
//                    message = removeResource();
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }

    public String createANewCollection() {
        String newCollectionName = Input.readString("Insert a name for the book collection: ");
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

    public String addBookToCollection() {
        String newBookName = Input.readString("Insert a name of the book: ");
        double bookPrice = Input.readDouble("Insert the book price in Euros: ");
        int estimatedTimeInSeconds = Input.readInt("Insert the book estimated reading time in seconds: ");
        int bookCategoryValue = Input.readInt("Choose a book category for book (1. Romance, 2. Fiction, 3. Biography, 4. History): ");
        if (bookCategoryValue > 5 || bookCategoryValue < 1) {
            System.out.println("Book category does not exist. Try again.");
            addBookToCollection();
        }
        BookCategory bookCategory = BookCategory.findByValue(bookCategoryValue);
        Book newBook = new Book(newBookName, bookPrice, estimatedTimeInSeconds, bookCategory);

        int counter = 0;
        for (int i = 0; i <= (bookCollectionArrayList.size() - 1); i++) {
            System.out.println((i + 1) + ". " + bookCollectionArrayList.get(i).getName());
        }

        int bookCollectionOption = Input.readInt("Choose an existing book collection: ");
        BookCollection bookCollection = bookCollectionArrayList.get(bookCollectionOption - 1);

        String bookCollectionName = bookCollection.getName();
        System.out.println(bookCollectionName);

//        BookCollection bookCollection = bookCollectionArrayList.stream()
//                .filter(d -> d.getName().equalsIgnoreCase(bookCollectionName))
//                .findFirst()
//                .orElseThrow(() -> new ItemNotFoundException("Doctor not found."));
//        System.out.println("Appointments for doctor " + bookCollectionName + ":");


        return "Book named: " + newBookName + "added successfully to collection: " + bookCollectionName;
    }

    public double calculateTotalValueInEuros() {
        return 0;
    }
}
