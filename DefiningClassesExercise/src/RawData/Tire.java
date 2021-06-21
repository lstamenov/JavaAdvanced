package RawData;

public class Tire {
    private double pressure;
    private int age;

    Tire(double pressure, int age){
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }
}
