import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (resources.get(input) == null){
                resources.put(input, quantity);
            }else {
                resources.put(input, resources.get(input) + quantity);
            }
            input = scanner.nextLine();
        }
        resources.forEach(((s, integer) -> System.out.println(s + " -> " + integer)));
    }
}
