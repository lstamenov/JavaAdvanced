import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lower = bounds[0];
        int higher = bounds[1];
        String type = reader.readLine();
        getNumbers(lower, higher, type);
    }
    public static void getNumbers(int lower, int higher, String type){
        Consumer<Integer> integerConsumer = num -> System.out.print(num + " ");
        if (type.equals("odd")){
            Predicate<Integer> integerPredicate = num -> num % 2 != 0;
            for (int i = lower; i <= higher; i++) {
                if (integerPredicate.test(i)){
                    integerConsumer.accept(i);
                }
            }
        }else {
            Predicate<Integer> integerPredicate = num -> num % 2 == 0;
            for (int i = lower; i <= higher; i++) {
                if (integerPredicate.test(i)){
                    integerConsumer.accept(i);
                }
            }
        }
    }
}
