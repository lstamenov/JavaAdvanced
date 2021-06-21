package PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");
            switch (data[0]){
                case "Create":
                    if (data[1].equals("Pet")){
                        String name = data[2];
                        int age = Integer.parseInt(data[3]);
                        String kind = data[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.add(pet);
                    }else {
                        if (Integer.parseInt(data[3]) % 2 == 0){
                            System.out.println("Invalid operation!");
                        }else {
                            Clinic clinic = new Clinic(data[2], Integer.parseInt(data[3]));
                            clinics.add(clinic);
                        }
                    }
                    break;
                case "Add":
                    System.out.println(Clinic.addPet(data[1], data[2], clinics, pets));
                    break;
                case "Release":
                    System.out.println(Clinic.release(data[1], clinics));
                    break;
                case "HasEmptyRooms":
                    System.out.println(Clinic.hasEmptyRooms(data[1], clinics));
                    break;
                case "Print":
                    if (data.length == 2){
                        Clinic.print(data[1], clinics);
                    }else {
                        Clinic.print(data[1], clinics, Integer.parseInt(data[2]));
                    }
                    break;
            }
        }
    }
}
