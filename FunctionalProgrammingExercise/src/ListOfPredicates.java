import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BiPredicate<Integer, List<Integer>> isDivisibleList = (integer, list) -> {
            int index = 0;
            int count = (int) IntStream.range(index, list.size()).filter(predicateIndex -> integer % list.get(predicateIndex) == 0).count();
            return count == list.size();
        };
        List<Integer> predicates = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        nums.stream()
                .filter(num -> isDivisibleList.test(num, predicates))
                .forEach(num -> System.out.print(num + " "));
    }
}
