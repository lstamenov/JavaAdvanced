import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Prices with VAT:");
        Consumer<Double> addVat = price -> System.out.printf("%.2f%n", price * 1.2);
        List<Double> doubleList = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        doubleList
                .forEach(addVat);
    }
}
