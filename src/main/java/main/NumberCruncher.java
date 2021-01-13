package main;

import java.util.Scanner;

public class NumberCruncher {

    private final static int DEFAULT_SIZE = 5;
    private double[] numberList;
    private final Scanner kb = new Scanner(System.in);

    public NumberCruncher(int size) {
        newList(size);
        displayIntro();
        getNumbers();
        displayList();
        displayCalcs();
    }

    public NumberCruncher() {
        this(DEFAULT_SIZE);
    }

    private void newList(int size) {
        numberList = new double[size];
    }

    private void displayIntro() {
        System.out.println("Welcome to Number Cruncher!");
        System.out.println("I'm going to ask you for " + numberList.length + " numbers, and then we'll analyze them!");
    }

    private double getSum() {
        double sum = 0;
        for (double num : numberList)
            sum += num;
        return sum;
    }

    private double getProduct() {
        double product = 1;
        for (double num : numberList
        ) {
            product *= num;
        }
        return product;
    }

    private double getLargest() {
        double largest = numberList[0];
        for (double num : numberList
        ) {
            if (num > largest) largest = num;
        }
        return largest;
    }

    private double getSmallest() {
        double smallest = numberList[0];
        for (double num : numberList
        ) {
            if (num < smallest) smallest = num;
        }
        return smallest;
    }

    private void getNumbers() {
        for (int i = 0; i < numberList.length; i++) {
            double userEntry = 0.666;
            boolean entryClean = false;
            while (!entryClean) {
                System.out.print("Please enter number #" + (i + 1) + ": ");
                try {
                    userEntry = Double.parseDouble(kb.nextLine());
                    entryClean = true;
                } catch (NumberFormatException e) {
                    System.out.println("Uh oh, got the error: " + e);
                    System.out.println("That's not a valid entry! Try again...");
                    entryClean = false;
                }
            }
            System.out.println("Got it! Adding " + userEntry + " to the list!");
            numberList[i] = userEntry;
        }
    }

    private void displayList() {
        System.out.println("Our number list: ");
        System.out.println(listBuilder(numberList));
    }

    private String listBuilder(double[] list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length; i++
        ) {
            builder.append(list[i]);
            if (i < list.length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private void displayCalcs() {
        System.out.println("--- Our calculations ---");
        System.out.println("Sum of all numbers: " + getSum());
        System.out.println("Product of all numbers: " + getProduct());
        System.out.println("Largest of all numbers: " + getLargest());
        System.out.println("Smallest of all numbers: " + getSmallest());
    }

}
