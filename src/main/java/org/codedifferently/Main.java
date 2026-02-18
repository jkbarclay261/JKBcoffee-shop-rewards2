package org.codedifferently;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create drinks
        CoffeeItem latte = new CoffeeItem("Latte", 4.50);
        CoffeeItem espresso = new CoffeeItem("Espresso", 3.00);
        CoffeeItem cappuccino = new CoffeeItem("Cappuccino", 5.00);

        System.out.println("Welcome to Triple C's!");

        boolean shopOpen = true;

        while (shopOpen) {

            System.out.println("\nEnter customer name:");
            String name = scanner.nextLine();

            System.out.println("Enter customer email:");
            String email = scanner.nextLine();

            Customer customer = new Customer(name, email, 0);

            System.out.println("\nMenu:");
            System.out.println("1. Latte");
            System.out.println("2. Espresso");
            System.out.println("3. Cappuccino");
            System.out.println("4. Close Shop");

            int choice = scanner.nextInt();

            if (choice == 4) {
                shopOpen = false;
                break;
            }

            CoffeeItem selectedDrink = null;

            if (choice == 1) {
                selectedDrink = latte;
            } else if (choice == 2) {
                selectedDrink = espresso;
            } else if (choice == 3) {
                selectedDrink = cappuccino;
            } else {
                System.out.println("Invalid choice.");
                scanner.nextLine(); // clear
                continue;
            }

            System.out.println("How many would you like?");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                continue;
            }

            double total = selectedDrink.getPrice() * quantity;

            System.out.println("\nCustomer: " + customer.getName());
            System.out.println("Drinks toward reward: " + customer.getDrinksPurchased());
            System.out.println("=========================");

            // Reward check
            if (customer.hasReward()) {

                System.out.println("CONGRATS! Reward reached. Next drink is free!");
                customer.redeemReward();
                System.out.println("=========================");
            } else {

                System.out.println(customer.getName() + " purchased "
                        + quantity + " " + selectedDrink.getName()
                        + "(s) for $" + total);

                // add drinks to reward counter
                for (int i = 0; i < quantity; i++) {
                    customer.incrementDrinks();
                }
            }

            // Golden Ticket
            if (total > 20) {
                System.out.println("Golden Ticket! You earned a bonus drink point!");
                customer.incrementDrinks();
                System.out.println("=========================");
            }

            System.out.println("Updated drinks toward reward: "
                    + customer.getDrinksPurchased());
            System.out.println("=========================");
            System.out.println("\nNext customer? (yes/no)");
            String answer = scanner.nextLine();
            System.out.println("=========================");
            if (answer.equalsIgnoreCase("no")) {
                shopOpen = false;
            }
        }

        System.out.println("Shop Closed!");
        scanner.close();
    }
}
