package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    Car (String model, Engine engine, Cargo cargo, Tire[] tires){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire[] getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public static boolean hasFlatTire(Car car){
        for (Tire t : car.getTires()) {
            if (t.getPressure() < 1){
                return true;
            }
        }
        return false;
    }
}
