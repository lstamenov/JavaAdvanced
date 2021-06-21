import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> nums = new LinkedHashMap<>();
        for (double n : arr) {
            nums.merge(n, 1, Integer::sum);
        }
        nums.forEach((aDouble, integer) -> System.out.println(aDouble + " -> " + integer));
    }
}
