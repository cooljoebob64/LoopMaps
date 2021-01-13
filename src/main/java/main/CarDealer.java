package main;

import java.util.*;

public class CarDealer {

    private final HashMap<String, String> carList = new HashMap<>();
    private final String[] DEFAULT_CARS = {
            "Civic", "Honda",
            "Viper", "Dodge",
            "Veloster", "Hyundai",
            "Elantra", "Hyundai",
            "Sonata", "Hyundai"
    };
    private final Scanner kb = new Scanner(System.in);

    public CarDealer() {
        addDefaultSilent();
        System.out.println("Welcome to the car dealer!");
        engageMeaningfully();
        System.out.println("Thanks for coming around! Hope our sales-bot wasn't too pushy!");
    }

    private void engageMeaningfully() {
        boolean keepGoing = true;
        String userResponse = "";
        while (keepGoing) {
            userResponse = talkToCustomer();
            keepGoing = checkOptions(userResponse);
            pressEnter();
        }
    }

    private String talkToCustomer() {
        System.out.println("Your options:");
        System.out.println("1: Make lookup (by model)");
        System.out.println("2: List models (by make)");
        System.out.println("3: Show the whole list of make/model");
        System.out.println("4: Add a new car to the list");
        System.out.println("5: Clear the list to empty");
        System.out.println("6: Add the default list back");
        System.out.println("Q: Quit");
        System.out.print("Your choice: ");
        return kb.nextLine();
    }

    private boolean checkOptions(String response) {
        int choice = 0;
        try {
            choice = Integer.parseInt(response);
        } catch (NumberFormatException e) {
            if (response.equalsIgnoreCase("q")) {
                System.out.println("No problem, see ya later!");
                return false;
            }
        }
        switch (choice) {
            case 1 -> makeLookup();
            case 2 -> listModels();
            case 3 -> showWholeList();
            case 4 -> addNewCar();
            case 5 -> clearList();
            case 6 -> addDefault();
            default -> repeatThat();
        }
        return true;
    }

    private void repeatThat() {
        System.out.println("Uh, I didn't get that, could you say again?");
    }

    private void makeLookup() {
        System.out.println("So you want to find the make, what's the model?");
        String userModel = kb.nextLine();
        String theMake = carList.get(userModel);
        if (theMake != null)
            System.out.println("Ah yes, the " + userModel + " is made by " + theMake);
        else System.out.println("I don't think I've heard of that one, least it ain't on our list!");
    }

    private void listModels() {
        System.out.println("What make would you like to see our list of?");
        String userMake = kb.nextLine();
        List<String> modelList = new ArrayList<>();
        for (String car : carList.keySet()
        ) {
            if (carList.get(car).equalsIgnoreCase(userMake)) {
                modelList.add(car);
            }
        }
        System.out.println("Here is a list of all the cars we have on our list from " + userMake + ":");
        for (String car : modelList
        ) {
            System.out.println("* " + userMake + " " + car);
        }
        System.out.println("Yep, that's all of 'em we've got from " + userMake + "!");
    }

    private void showWholeList() {
        System.out.println("Here's the whole list of cars:");
        for (String car : carList.keySet()
        ) {
            System.out.println("* " + carList.get(car) + " " + car);
        }
        System.out.println("That's everything!");
    }

    private void addNewCar() {
        System.out.println("Oh, you want to add a car to the list?");
        System.out.println("Well you must be from the manufacturer, I'll trust whatever you tell me completely!");
        System.out.println("That car you want to add, tell me the make:");
        String userMake = kb.nextLine();
        System.out.println("And also tell me the model:");
        String userModel = kb.nextLine();
        System.out.println("Right, so that's the " + userMake + " " + userModel + "...");
        System.out.println("That a real car? Aw shucks who am I kidding, you're from " + userMake + " after all!");
        addCar(userModel, userMake);
        System.out.println("Alright, it's on the list now! Thanks for the update!");
    }

    private void clearList() {
        System.out.println("Oh, you want to clear the whole list? I guess we can do that...");
        carList.clear();
        System.out.println("All gone! Our car list is empty now. I can go home early, yippee! Unless you need something else...");
    }

    private void addDefault() {
        System.out.println("Adding the defaults back to the car list...");
        for (int i = 0; i < DEFAULT_CARS.length; i += 2) {
            String car1 = DEFAULT_CARS[i];
            String car2 = DEFAULT_CARS[i + 1];
            System.out.println("Adding the " + car2 + " " + car1 + " to the list...");
            addCar(car1, car2);
        }
        System.out.println("Done!");
    }

    private void addDefaultSilent() {
        for (int i = 0; i < DEFAULT_CARS.length; i += 2) {
            String car1 = DEFAULT_CARS[i];
            String car2 = DEFAULT_CARS[i + 1];
            addCar(car1, car2);
        }
    }

    private void addCar(String model, String make) {
        try {
            carList.put(model, make);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding car to the list: " + e);
            System.out.println("You tried to add Make: " + make + ", Model: " + model);
        }
    }

    private void pressEnter() {
        System.out.print("Press Enter to continue...");
        kb.nextLine();
    }
}
