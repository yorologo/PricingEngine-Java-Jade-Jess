package gov.sandia.jess.example.pricing.model.items;

public class Computer {
    private final String model;
    private final String brand;

    public Computer(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
    
}
