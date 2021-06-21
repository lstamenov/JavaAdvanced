import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOnCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> decks = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String[] cards = data[1].split(", ");
            int sum = 0;
            for (String card : cards) {
                sum += getCardPower(card);
            }
            decks.put(name, sum);
            input = scanner.nextLine();
        }
        decks.forEach((s, integer) -> System.out.printf("%s: %d%n", s, integer));
    }

    private static int getCardPower(String card) {
        int power = getPower(card);
        int type = getType(card);

        return power * type;
    }

    private static int getType(String card) {
        return switch (card.charAt(card.length() - 1)) {
            case 'S' -> 4;
            case 'H' -> 3;
            case 'D' -> 2;
            default -> 1;
        };
    }

    private static int getPower(String card) {
        if (card.length() == 2){
            if (Character.isDigit(card.charAt(0))){
                return card.charAt(0) - 48;
            }else {
                switch (card.charAt(0)){
                    case 'J':
                        return 11;
                    case 'K':
                        return 13;
                    case 'Q':
                        return 12;
                    case 'A':
                        return 14;
                }
            }
        }else {
            return 10;
        }
        return 1;
    }
}
