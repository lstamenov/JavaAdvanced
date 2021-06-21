package CarInfoUpgraded;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    Car (String brand){
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    Car (String brand, String model, int horsePower){
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("This car is: %s %s - %d HP.",
                getBrand(), getModel(), getHorsePower());
    }
}
