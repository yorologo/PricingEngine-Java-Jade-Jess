package gov.sandia.jess.example.pricing.model;

import java.text.DecimalFormat;

public class Offer {
    private float amount;
    private float vouchers;
    private final String description;
    private static DecimalFormat formatter1 = new DecimalFormat("-$0.00");
    private static DecimalFormat formatter2 = new DecimalFormat("$0");

    public Offer(String aDescription, float anAmount) {
        description = aDescription;
        amount = anAmount;
    }

    public Offer(String aDescription, float anAmount, float aVouchers) {
        description = aDescription;
        vouchers = aVouchers;
    }

    public Offer(String aDescription) {
        description = aDescription;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        if (vouchers > 0) {
            return description + ": " + formatter2.format(Math.floor(vouchers));
        } else if (amount > 0) {
            return description + ": " + formatter1.format(amount);
        } else {
            return description;
        }
    }

}