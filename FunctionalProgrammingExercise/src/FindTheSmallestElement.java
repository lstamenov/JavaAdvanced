import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> getSmallestElementIndex = list -> {
            AtomicInteger smallestNumber = new AtomicInteger(Integer.MAX_VALUE);
            IntStream.range(0, list.size())
                    .forEach(index -> {
                        if (list.get(index) < smallestNumber.get()){
                            smallestNumber.set(list.get(index));
                        }
                    });
            return Integer.parseInt(String.valueOf(smallestNumber));
        };
        System.out.println(nums.indexOf(getSmallestElementIndex.apply(nums)));
    }
}
