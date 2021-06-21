package CatLady;

public class Cat {
    private String name;
    private String breed;
    private double variable;

    Cat(String name, String breed, double variable){
        this.name = name;
        this.breed = breed;
        this.variable = variable;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", breed, name, variable);
    }
}
