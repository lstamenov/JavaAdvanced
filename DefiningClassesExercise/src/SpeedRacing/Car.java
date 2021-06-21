package SpeedRacing;

public class Car {
    String model;
    double fuel;
    double fuelCostPerKilometer;
    int distanceTraveled;

    Car (String model, double fuel, double fuelCostPerKilometer){
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void drive(int kilometers){
        if (kilometers * fuelCostPerKilometer <= fuel){
            fuel -= kilometers * fuelCostPerKilometer;
            distanceTraveled += kilometers;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                getModel(), getFuel(), getDistanceTraveled());
    }
}
