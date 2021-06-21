import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, List<Integer>> convert = s -> {
          return Arrays.stream(s.split("\\s+"))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
        };
        Function<List<Integer>, Integer> min = integers -> {
            return integers.stream().mapToInt(integer -> integer).min().orElse(Integer.MAX_VALUE);
        };
        List<Integer> nums = convert.apply(reader.readLine());
        System.out.println(min.apply(nums));
    }
}
