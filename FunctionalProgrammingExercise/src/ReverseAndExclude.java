import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());
        Predicate<Integer> filterDivisible = integer -> integer % n != 0;
        numbers = numbers.stream()
                .filter(filterDivisible)
                .collect(Collectors.toList());
        Collections.reverse(numbers);
        numbers.forEach(number -> System.out.print(number + " "));
    }
}
