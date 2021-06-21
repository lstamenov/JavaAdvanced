import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Compare comparator = new Compare();
        nums.stream()
                .sorted(comparator)
                .forEach(integer -> System.out.print(integer + " "));
    }
    static class Compare implements Comparator<Integer> {
        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        @Override
        public int compare(Integer o1, Integer o2) {
            if (!isEven.test(o1) && isEven.test(o2)){
                return 1;
            }else if (isEven.test(o1) && !isEven.test(o2)){
                return -1;
            }else {
                return o1.compareTo(o2);
            }
        }
    }
}
