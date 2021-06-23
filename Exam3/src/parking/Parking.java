package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (capacity > data.size()){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        for (Car p : this.data) {
            if (p.getManufacturer().equals(manufacturer) &&
            p.getModel().equals(model)){
                data.remove(p);
                return true;
            }
        }
        return false;
    }

    public Car getCar(String manufacturer, String model){
        for (Car p : this.data) {
            if (p.getModel().equals(model) &&
                    p.getManufacturer().equals(manufacturer)){
                return p;
            }
        }
        return null;
    }

    public Car getLatestCar(){
        int oldest = Integer.MIN_VALUE;
        for (Car p : this.data) {
            if (p.getYear() > oldest){
                oldest = p.getYear();
            }
        }
        for (Car p : this.data) {
            if (p.getYear() == oldest){
                return p;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder("The cars are parked in " + type + ":");
        for (Car p : this.data) {
            result.append(String.format("%n%s", p));
        }
        return result.toString();
    }
}
