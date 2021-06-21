import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Map<String, List<String>>> cities = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if (cities.get(continent) == null){
                Map<String, List<String>> countries = new LinkedHashMap<>();
                countries.put(country, new ArrayList<>());
                countries.get(country).add(city);
                cities.put(continent, countries);
            }else {
                if (cities.get(continent).get(country) == null){
                    Map<String, List<String>> countries = cities.get(continent);
                    countries.put(country, new ArrayList<>());
                    countries.get(country).add(city);
                    cities.put(continent, countries);
                }else {
                    cities.get(continent).get(country).add(city);
                }
            }

        }
        cities.forEach((key, value) -> {
            System.out.println(key+":");
            value.forEach((key1, value1) -> System.out.println("  "+ key1 + " -> " + String.join(", ", value1)));
        });
    }
}
