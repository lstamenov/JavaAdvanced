import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] data = input.split("\\s+");
            String user = data[2].substring(5);
            String ip = data[0].substring(3);
            if (users.get(user) == null){
                users.put(user, new LinkedHashMap<>());
                users.get(user).put(ip, 1);
            }else {
                if (users.get(user).get(ip) == null){
                    users.get(user).put(ip, 1);
                }else {
                    users.get(user).put(ip, users.get(user).get(ip) + 1);
                }
            }
            input = scanner.nextLine();
        }
        users.
                forEach((s, stringIntegerLinkedHashMap) -> {
                    System.out.println(s+": ");
                    AtomicInteger count = new AtomicInteger();
                    stringIntegerLinkedHashMap.
                            forEach((s1, integer) -> {
                                count.getAndIncrement();
                                if (count.get() == stringIntegerLinkedHashMap.size()) {
                                    System.out.printf("%s => %d.%n",s1 ,integer);
                                }else {
                                    System.out.printf("%s => %d, ",s1 ,integer);
                                }
                            });
                });
    }
}
