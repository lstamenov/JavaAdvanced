package CarSalesman;

public class Engine {

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    Engine (String model, int power){
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

}
