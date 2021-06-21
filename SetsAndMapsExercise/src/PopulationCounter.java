
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")){
            String[] data = input.split("\\|");
            String country = data[1];
            String city = data[0];
            long population = Long.parseLong(data[2]);
            if (countries.get(country) == null){
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(city, population);
            }else {
                countries.get(country).put(city, population);
            }
            input = scanner.nextLine();
        }
        countries.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(getTotalPopulation(e2), getTotalPopulation(e1)))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), getTotalPopulation(e));
                    e.getValue().entrySet()
                            .stream()
                            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                            .forEach(c -> System.out.printf("=>%s: %d%n",c.getKey(), c.getValue() ));
                });
    }

    private static long getTotalPopulation(Map.Entry<String, LinkedHashMap<String, Long>> e1) {
        long total = 0;
        for (Map.Entry<String, Long> e : e1.getValue().entrySet()) {
            total += e.getValue();
        }
        return total;
    }

}
