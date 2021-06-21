import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Predicate<Integer> predicate = integer -> integer % 2 == 0;
        List<Integer> list = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .filter(predicate)
                .sorted()
                .collect(Collectors.toList());
        String collect = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
