import java.util.LinkedHashSet;
import java.util.Scanner;

public class CarParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> parking = new LinkedHashSet<>();
        while (!input.equals("END")){
            String[] commands = input.split(", ");
            String command = commands[0];
            String plate = commands[1];
            if (command.equals("IN")){
                parking.add(plate);
            }else {
                parking.remove(plate);
            }
            input = scanner.nextLine();
        }
        if (parking.size() > 0)
            System.out.println(String.join(System.lineSeparator(), parking));
        else
            System.out.println("Parking Lot is Empty");
    }
}
