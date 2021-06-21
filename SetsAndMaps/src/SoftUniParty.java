import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> listVIP = new LinkedHashSet<>();
        Set<String> listRegular = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")){
            if(input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    listVIP.add(input);
                }else {
                    listRegular.add(input);
                }
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            if (Character.isDigit(input.charAt(0))){
                listVIP.remove(input);
            }else {
                listRegular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(listVIP.size() + listRegular.size());
        listVIP.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
        listRegular.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
