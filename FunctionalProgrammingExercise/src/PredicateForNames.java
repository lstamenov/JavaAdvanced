import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nameLength = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split("\\s+");
        BiPredicate<String, Integer> predicate = (s, integer) -> s.length() <= integer;
        Arrays.stream(arr)
                .filter(s -> predicate.test(s, nameLength))
                .forEach(System.out::println);
    }
}
