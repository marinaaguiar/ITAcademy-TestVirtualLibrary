package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    private static void exception(Exception e) {
        System.out.println("Invalid format.");
        scanner.nextLine();
    }

    private static void inputMismatchException(Exception e) {
        System.out.println("Invalid format.");
        scanner.nextLine();
    }

    public static String readString(String message) {
        Scanner scannerString = new Scanner(System.in);
        Boolean isValid  = false;
        String userInput = "";
        while  (!isValid && userInput.length() == 0) {
            try {
                System.out.println(message);
                userInput = scannerString.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        }
        return userInput;
    }

    public static int readInt(String message) {
        Scanner scannerInt = new Scanner(System.in);
        try {
            System.out.print(message);
            int intInfo = scannerInt.nextInt();
            return intInfo;
        } catch (InputMismatchException e) {
            scannerInt.nextLine();
            throw new InputMismatchException("Input Invalid! Format Error: Expected an Int format - (e.g. 1).");
        }
    }

    public static double readDouble(String message) {
        Scanner scannerDouble = new Scanner(System.in);
        try {
            System.out.print(message);
            double intInfo = scannerDouble.nextDouble();
            return intInfo;
        } catch (InputMismatchException e) {
            scannerDouble.nextLine();
            throw new InputMismatchException("Input Invalid! Format Error: Expected an Int format - (e.g. 1).");
        }
    }

}