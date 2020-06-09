package gov.sandia.jess.example.pricing.model;

import java.text.DecimalFormat;

import gov.sandia.jess.example.pricing.model.items.CreditCard;

public class OrderItem {
    private static DecimalFormat formatter = new DecimalFormat("0.00");
    private float price;
    private int partNumber;
    private String description;
    private String creditCard;
    private int quantity;

    public OrderItem(String aDescription, int aPartNumber, float aPrice, int aQuantity) {
        partNumber = aPartNumber;
        description = aDescription;
        price = aPrice;
        quantity = aQuantity;
    }

    public OrderItem(Object aDescription, int aPartNumber, float aPrice, int aQuantity) {
        partNumber = aPartNumber;
        description = aDescription.toString();
        price = aPrice;
        quantity = aQuantity;
    }

    // Card payment
    public OrderItem(String aDescription, int aPartNumber, float aPrice, int aQuantity, CreditCard aCreditCard) {
        partNumber = aPartNumber;
        description = aDescription;
        price = aPrice;
        quantity = aQuantity;
        creditCard = aCreditCard.getBank();
    }

    public OrderItem(Object aDescription, int aPartNumber, float aPrice, int aQuantity, CreditCard aCreditCard) {
        partNumber = aPartNumber;
        description = aDescription.toString();
        price = aPrice;
        quantity = aQuantity;
        creditCard = aCreditCard.getBank();
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public float getTotal() {
        return price * quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String toString() {
        return quantity + " " + description + ": " + formatter.format(getTotal());
    }
}