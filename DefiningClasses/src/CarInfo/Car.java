package CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    Car (String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(), getModel(), getHorsePower());
    }
}
