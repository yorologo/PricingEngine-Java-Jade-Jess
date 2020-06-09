package gov.sandia.jess.example.pricing.model.items;

public class CreditCard {
    private final String name;
    private final String type;

    public CreditCard(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getname() {
        return name;
    }

    public String getType() {
        return type;
    }
    
}
