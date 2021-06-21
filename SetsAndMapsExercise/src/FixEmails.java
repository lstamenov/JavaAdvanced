import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String email = scanner.nextLine();
            String substring = email.substring(email.length() - 2);
            if (!substring.equalsIgnoreCase("uk") && !substring.equalsIgnoreCase("us")
            && !email.substring(email.length() - 3).equalsIgnoreCase("com")){
                emails.put(input, email);
            }
            input = scanner.nextLine();
        }
        emails.forEach((s, s2) -> System.out.printf("%s -> %s%n",s, s2));
    }
}
