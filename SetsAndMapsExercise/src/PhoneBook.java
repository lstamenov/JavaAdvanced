import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneNumbers = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")){
            String[] details = input.split("-");
            phoneNumbers.put(details[0], details[1]);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){
            if (phoneNumbers.get(input) == null){
                System.out.printf("Contact %s does not exist.%n", input);
            }else {
                System.out.println(input + " -> " + phoneNumbers.get(input));
            }
            input = scanner.nextLine();
        }
    }
}
