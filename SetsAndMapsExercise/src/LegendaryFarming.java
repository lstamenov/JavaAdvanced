import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        while (keyMaterials.get("shards") < 250 && keyMaterials.get("fragments") < 250
        && keyMaterials.get("motes") < 250){
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");
            for (int i = 0; i < data.length - 1; i++) {
                String name = data[i + 1];
                int quantity = Integer.parseInt(data[i]);
                if (isKey(name)){
                    keyMaterials.merge(name.toLowerCase(), quantity, Integer::sum);
                }else {
                    junkMaterials.merge(name.toLowerCase(), quantity, Integer::sum);
                }
                if (keyMaterials.get("shards") >= 250 || keyMaterials.get("fragments") >= 250 ||
                        keyMaterials.get("motes") >= 250){
                    break;
                }
                i++;
            }
        }
        if (keyMaterials.get("shards") >= 250){
            System.out.println("Shadowmourne obtained!");
            keyMaterials.put("shards", keyMaterials.get("shards") - 250);
        }else if ((keyMaterials.get("fragments") >= 250)){
            System.out.println("Valanyr obtained!");
            keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
        }else {
            System.out.println("Dragonwrath obtained!");
            keyMaterials.put("motes", keyMaterials.get("motes") - 250);
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(stringIntegerEntry -> System.out.printf("%s: %d%n", stringIntegerEntry.getKey(),
                        stringIntegerEntry.getValue()));
        junkMaterials.
                forEach((s, integer) -> System.out.printf("%s: %d%n",s, integer));
    }
    private static boolean isKey(String name){
        return name.equalsIgnoreCase("Shards") ||
                name.equalsIgnoreCase("Fragments") ||
                name.equalsIgnoreCase("Motes");
    }
}
