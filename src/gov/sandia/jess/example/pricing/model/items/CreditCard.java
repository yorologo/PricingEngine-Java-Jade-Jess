package gov.sandia.jess.example.pricing.model.items;

public class CreditCard {
    private final String bank;
    private final String type;

    public CreditCard(String bank, String type) {
        this.bank = bank;
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public String getType() {
        return type;
    }
    
}
