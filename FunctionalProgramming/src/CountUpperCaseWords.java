import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Predicate<String> isLowerCase = s -> Character.isUpperCase(s.charAt(0));
        List<String> strings = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(isLowerCase)
                .collect(Collectors.toList());
        System.out.println(strings.size());
        Consumer<String> consumer = System.out::println;
        strings.forEach(consumer);
    }
}
