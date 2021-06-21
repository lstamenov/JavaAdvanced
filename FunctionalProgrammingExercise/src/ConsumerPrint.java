import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, String[]> toArr = s -> s.split("\\s+");
        Consumer<String[]> consumer = strings -> {
            for (String s : strings) {
                System.out.println(s);
            }
        };
        String[] arr = toArr.apply(reader.readLine());
        consumer.accept(arr);
    }
}
