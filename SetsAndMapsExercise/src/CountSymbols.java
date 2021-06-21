import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbols = new TreeMap<>();
        String sentence = scanner.nextLine();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (symbols.get(c) == null){
                symbols.put(c, 1);
            }else {
                symbols.put(c, symbols.get(c) + 1);
            }
        }
        symbols.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
