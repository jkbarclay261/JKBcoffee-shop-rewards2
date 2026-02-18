package org.codedifferently;

public class Customer {

    private String name;
    private String phoneNumber;
    private int drinksPurchased;

    // Constructor
    public Customer(String name, String phoneNumber, int drinksPurchased) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.drinksPurchased = drinksPurchased;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getDrinksPurchased() {
        return drinksPurchased;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDrinksPurchased(int drinksPurchased) {
        this.drinksPurchased = drinksPurchased;
    }

    // Add one drink to rewards counter
    public void incrementDrinks() {
        drinksPurchased = drinksPurchased + 1;
    }

    // Check if customer has reward (5 drinks)
    public boolean hasReward() {
        if (drinksPurchased >= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Redeem reward (reset count)
    public void redeemReward() {
        drinksPurchased = 0;
    }

    public String getCustomerInfo() {
        return "Name: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nDrinks Purchased: " + drinksPurchased;
    }
}
