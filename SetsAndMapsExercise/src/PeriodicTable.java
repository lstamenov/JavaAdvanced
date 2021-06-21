    import java.util.Arrays;
    import java.util.LinkedHashSet;
    import java.util.Scanner;
    import java.util.Set;

    public class PeriodicTable {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            Set<String> elements = new LinkedHashSet<>();
            for (int i = 0; i < n; i++) {
                String[] arr = scanner.nextLine().split("\\s+");
                elements.addAll(Arrays.asList(arr));
            }
            elements.
                    stream()
                    .sorted()
                    .forEach(e -> System.out.print(e + " "));
        }
    }
