import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AtomicInteger sum = new AtomicInteger();
        Consumer<Integer> consumer = sum::addAndGet;
        List<Integer> integers = Arrays.stream(
                reader.readLine().split(", ")
        )
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        integers.forEach(consumer);
        System.out.println("Count = " + integers.size());
        System.out.println("Sum = " + sum);

    }
}
