import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, List<String>> convertToList = s -> Arrays.asList(s.split("\\s+"));
        Consumer<List<String>> printKnights = strings -> {
          strings
          .forEach(s -> System.out.println("Sir " + s));
        };
        List<String> list = convertToList.apply(reader.readLine());
        printKnights.accept(list);
    }
}
