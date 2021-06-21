import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, List<Integer>> convert = s -> {
            return Arrays.stream(s.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        };
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(integer -> integer += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(integer -> integer *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(integer -> integer -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printer = list -> list.forEach(integer ->  System.out.print(integer + " "));
        List<Integer> list = convert.apply(reader.readLine());
        String input = reader.readLine();
        while (!input.equals("end")){
            switch (input) {
                case "add" -> list = add.apply(list);
                case "multiply" -> list = multiply.apply(list);
                case "subtract" -> list = subtract.apply(list);
                case "print" -> printer.accept(list);
            }
            input = reader.readLine();
        }
    }
}
