import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        scanner.close();
        for (int i = 0; i < n; i++) {
            queue.offer(plants[i]);
        }

        int days = 0;
        while (!isOver(queue)) {
            Iterator<Integer> iterator = queue.iterator();
            int previousPesticide = iterator.next();
            while (iterator.hasNext()) {
                int currPesticide = iterator.next();
                if (previousPesticide < currPesticide) {
                    previousPesticide = currPesticide;
                    iterator.remove();
                } else {
                    previousPesticide = currPesticide;
                }
            }
            days++;
        }

        System.out.println(days);
    }

    private static boolean isOver(ArrayDeque<Integer> queue) {
        Iterator<Integer> it = queue.iterator();
        int curr = it.next();
        while (it.hasNext()){
            int next = it.next();
            if (curr < next){
                return false;
            }else {
                curr = next;
            }
        }
        return true;
    }
}
