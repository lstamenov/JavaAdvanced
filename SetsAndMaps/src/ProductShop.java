import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] arr = input.split(", ");
            String shop = arr[0];
            String product = arr[1];
            double price = Double.parseDouble(arr[2]);
            if (shops.get(shop) == null){
                shops.put(shop, new LinkedHashMap<>());
                shops.get(shop).put(product, price);
            }else {
                shops.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }
        shops.forEach((key, value) -> {
            System.out.println(key + "->");
            for (Map.Entry<String, Double> e : value.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", e.getKey()
                        , e.getValue());
            }
        });
    }
}
