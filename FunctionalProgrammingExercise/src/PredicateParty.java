import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> length = (s, integer) -> s.length() == integer;
        BiFunction<List<String>, String[], List<String>> getList = (list, stringArr) -> {
            List<String> guestsToAdd;
            String command = stringArr[0];
            String value = stringArr[1];
            guestsToAdd = switch (command) {
                case "StartsWith" -> guests.stream()
                        .filter(name -> startsWith.test(name, value))
                        .collect(Collectors.toList());
                case "EndsWith" -> guests.stream()
                        .filter(name -> endsWith.test(name, value))
                        .collect(Collectors.toList());
                case "Length" -> guests.stream()
                        .filter(name -> length.test(name, Integer.parseInt(value)))
                        .collect(Collectors.toList());
                default -> throw new IllegalStateException("Unexpected value: " + command);
            };
            return guestsToAdd;
        };
        String input = reader.readLine();
        while (!input.equals("Party!")) {
            String[] inputData = input.split("\\s+");
            switch (inputData[0]) {
                case "Remove":
                    List<String> guestsToRemove = getList.apply(guests, new String[]{inputData[1], inputData[2]});
                    guests.removeIf(guestsToRemove::contains);
                    break;
                case "Double":
                    guestsToRemove = getList.apply(guests, new String[]{inputData[1], inputData[2]});
                    guests.addAll(guestsToRemove);
                    break;
            }
            input = reader.readLine();
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }
}
