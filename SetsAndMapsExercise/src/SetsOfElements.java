import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> common = new LinkedHashMap<>();
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nums[0] + nums[1]; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (common.get(n) == null){
                common.put(n, 1);
            }else {
                common.put(n, common.get(n) + 1);
            }
        }
        common.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.print(e.getKey() + " "));
    }
}
