package PetClinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Pet> {

    private List<Pet> rooms;
    private String name;
    private int roomsCount;
    int roomIndex;

    Clinic(String name, int roomsCount) {
        this.name = name;
        this.roomsCount = roomsCount;
        this.rooms = new ArrayList<>();
        this.roomIndex = 0;
        for (int i = 0; i < roomsCount; i++) {
            rooms.add(null);
        }
    }

    public String getName() {
        return name;
    }

    public List<Pet> getRooms() {
        return rooms;
    }
    public static boolean release(String clinicName, List<Clinic> clinics){
        int index = returnClinicIndexByName(clinicName, clinics);
        Clinic clinic;
        if (index != -1){
            clinic = clinics.get(index);
        } else {
            return false;
        }
        int centerIndex = clinic.getRooms().size() / 2;
        for (int i = centerIndex; i < clinic.getRooms().size(); i++) {
            if (clinic.getRooms().get(i) != null){
                clinic.getRooms().set(i, null);
                return true;
            }
        }
        for (int i = centerIndex - 1; i >= 0; i--) {
            if (clinic.getRooms().get(i) != null){
                clinic.getRooms().set(i, null);
                return true;
            }
        }
        return false;
    }

    public static boolean addPet(String petName, String clinicName,
                                 List<Clinic> clinics, List<Pet> pets) {
        int clinicIndex = returnClinicIndexByName(clinicName, clinics);
        int petIndex = returnPetIndexByName(petName, pets);
        if (clinicIndex != -1 && petIndex != -1){
            Clinic clinic = clinics.get(clinicIndex);
            Pet pet = pets.get(petIndex);
            if (hasEmptyRooms(clinicName, clinics)){
                int centerIndex = clinic.getRooms().size() / 2;
                if (clinic.getRooms().get(centerIndex) == null){
                    clinic.getRooms().set(centerIndex, pet);
                    return true;
                }else {
                    int counterLeft = 0;
                    int counterRight = 0;
                    for (int i = centerIndex - 1; i >= 0; i--) {
                        counterLeft++;
                    }
                    for (int i = centerIndex + 1; i < clinic.getRooms().size(); i++) {
                        counterRight++;
                    }
                    if (counterLeft == counterRight){
                        clinic.rooms.set(counterLeft - 1, pet);
                    }else {
                        clinic.rooms.set(counterRight - 1, pet);
                    }
                }
                clinics.set(clinicIndex, clinic);
                return true;
            }
        }
        return false;
    }

    public static void print(String clinicName, List<Clinic> clinics){
        int index = returnClinicIndexByName(clinicName, clinics);
        if (index != -1){
            for (int i = 0; i < clinics.get(index).roomsCount; i++) {
                if (clinics.get(index).getRooms().get(i) != null){
                    System.out.println(clinics.get(index).getRooms().get(i));
                }else {
                    System.out.println("Room empty");
                }
            }
        }
    }

    public static void print(String clinicName, List<Clinic> clinics, int indexRoom){
        int index = returnClinicIndexByName(clinicName, clinics);
        System.out.println(clinics.get(index).getRooms().get(indexRoom - 1));
    }

    public static boolean hasEmptyRooms(String clinicName, List<Clinic> clinics){
        int clinicIndex = returnClinicIndexByName(clinicName, clinics);
        if (clinicIndex != -1){
            for (Pet petRooms : clinics.get(clinicIndex).getRooms()) {
                if (petRooms == null){
                    return true;
                }
            }
        }
        return false;
    }

    public static int returnClinicIndexByName (String clinicName, List<Clinic> clinics){
        for (Clinic c : clinics) {
            if (c.getName().equals(clinicName)){
                return clinics.indexOf(c);
            }
        }
        return -1;
    }
    public static int returnPetIndexByName (String petName, List<Pet> pets){
        for (Pet p : pets) {
            if (p.getName().equals(petName)){
                return pets.indexOf(p);
            }
        }
        return -1;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new PetIterator();
    }

    class PetIterator implements Iterator<Pet>{

        @Override
        public boolean hasNext() {
            return roomIndex < roomsCount - 1;
        }

        @Override
        public Pet next() {
            return rooms.get(roomIndex++);
        }
    }
}
