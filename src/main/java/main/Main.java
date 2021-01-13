package main;

import java.util.Scanner;

public class Main {

    private final static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {

        boolean goodInput = false;
        String userResponse = "";

        System.out.println("Welcome to the Loop Mapping Exercise!");
        pressEnter();

        boolean keepGoing = true;

        while (keepGoing) {
            int choice = 0;
            goodInput=false;
            while (!goodInput) {
                System.out.println("Which program would you like to run?");
                System.out.println("1. Number Cruncher");
                System.out.println("2. Car Dealer");
                System.out.println("Q. Quit");
                userResponse = kb.nextLine();

                try {
                    choice = Integer.parseInt(userResponse);
                    goodInput = true;
                } catch (NumberFormatException e) {
                    if (userResponse.contains("q")) {
                        goodInput = true;
                        keepGoing = false;
                        System.out.println("Quitting the program!");
                    } else {
                        System.out.println("Received error: " + e);
                        System.out.println("Invalid entry! Try again...");
                        goodInput = false;
                    }
                }

            }
            switch (choice) {
                case 0 -> System.out.println("Goodbye!");
                case 1 -> launchNumberCruncher();
                case 2 -> launchCarDealer();
                default -> System.out.println("Something went wrong! No valid option selected! You said: " + userResponse);
            }


        }

        System.out.println("Program complete!");
    }

    private static void launchNumberCruncher(){
        System.out.println("Launching Number Cruncher!");
        pressEnter();
        new NumberCruncher();
    }

    private static void launchCarDealer(){
        System.out.println("Launching Car Dealer!");
        pressEnter();
        new CarDealer();
//        System.out.println("Car dealer not implemented yet! Check back soon!");
//        pressEnter();
    }

    private static void pressEnter(){
        System.out.print("Press Enter to continue...");
        kb.nextLine();
    }
}
