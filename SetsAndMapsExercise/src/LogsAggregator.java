import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, Integer>> logs = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String user = data[1];
            String userIP = data[0];
            int duration = Integer.parseInt(data[2]);
            if (logs.get(user) == null){
                logs.put(user, new TreeMap<>());
                logs.get(user).put(userIP, duration);
            }else {
                if (logs.get(user).get(userIP) == null) {
                    logs.get(user).put(userIP, duration);
                }else {
                    int a = logs.get(user).get(userIP);
                    logs.get(user).put(userIP, duration + a);
                }
            }
        }
        logs.entrySet()
                .forEach(entry -> {
                    AtomicInteger count = new AtomicInteger(1);
                    System.out.printf("%s: %d ",entry.getKey(), getTotalDuration(entry));
                    entry.getValue()
                            .forEach((s, integer) -> {
                                if (entry.getValue().size() == 1){
                                    System.out.printf("[%s]", s);
                                }else {
                                    if (count.get() == 1){
                                        System.out.printf("[%s, ", s);
                                    }else if (count.get() == entry.getValue().size()){
                                        System.out.printf("%s]", s);
                                    }else {
                                        System.out.printf("%s, ", s);
                                    }
                                }
                                count.getAndIncrement();
                            });
                    System.out.println();
                });
    }
    private static long getTotalDuration(Map.Entry<String, TreeMap<String, Integer>> entry){
        long total = 0;
        for (Map.Entry<String, Integer> e : entry.getValue().entrySet()) {
            total += e.getValue();
        }
        return total;
    }
}
