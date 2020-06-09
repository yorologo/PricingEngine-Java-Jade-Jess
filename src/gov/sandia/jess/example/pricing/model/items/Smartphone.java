package gov.sandia.jess.example.pricing.model.items;

public class Smartphone {
    private final String model;
    private final String brand;

    public Smartphone(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
    
    @Override
    public String toString() {
        return model + " by " + brand;
    }
}
