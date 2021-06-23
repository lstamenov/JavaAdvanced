package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (capacity > data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet p : this.data) {
            if (p.getName().equals(name)){
                data.remove(p);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)){
                return p;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        int oldest = Integer.MIN_VALUE;
        for (Pet p : this.data) {
            if (p.getAge() > oldest){
                oldest = p.getAge();
            }
        }
        for (Pet p : this.data) {
            if (p.getAge() == oldest){
                return p;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder("The clinic has the following patients:");
        for (Pet p : this.data) {
            result.append(String.format("%n%s %s", p.getName(), p.getOwner()));
        }
        return result.toString();
    }
}
