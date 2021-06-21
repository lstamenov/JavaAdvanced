package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s", getModel(), getEngine().getModel(), getEngine().getPower()
        , getEngine().getDisplacement(), getEngine().getEfficiency(), getWeight(), getColor());
    }
}
