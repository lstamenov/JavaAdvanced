import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String singer = "";
            String venue = "";
            int price = 0;
            int tickets = 0;
            switch (data.length){
                case 5:
                    if (data[1].contains("@")){
                        singer = data[0];
                        venue = data[1].substring(1);
                        venue += " ";
                        venue += data[2];
                    }else {
                        singer = data[0];
                        singer += " ";
                        singer += data[1];
                    }
                    price = Integer.parseInt(data[3]);
                    tickets = Integer.parseInt(data[4]);
                    break;
                case 6:
                    singer = data[0];
                    singer += " ";
                    singer += data[1];
                    venue = data[2].substring(1);
                    venue += " ";
                    venue += data[3];
                    price = Integer.parseInt(data[4]);
                    tickets = Integer.parseInt(data[5]);
                default:
                    break;
            }
            if (venues.get(venue) == null){
                venues.put(venue, new LinkedHashMap<>());
                venues.get(venue).put(singer, price * tickets);
            }else {
                if (venues.get(venue).get(singer) == null) {
                    venues.get(venue).put(singer, price * tickets);
                }else {
                    int oldSum = venues.get(venue).get(singer);
                    venues.get(venue).put(singer, oldSum + (tickets * tickets));
                }
            }

            input = scanner.nextLine();
        }
        venues.
                forEach((s, stringIntegerLinkedHashMap) -> {
                    System.out.println(s);
                    stringIntegerLinkedHashMap.entrySet()
                            .stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(e -> System.out.printf("#  %s -> %d%n",e.getKey(),
                                    e.getValue()));
                });
    }
}
