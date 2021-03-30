import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrInf = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int numsToAdd = arrInf[0];
        int numsToRemove = arrInf[1];
        int num = arrInf[2];

        for (int i = 0; i < numsToAdd; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < numsToRemove; i++) {
            queue.poll();
        }

        System.out.println(getElement(queue, num));
    }

    private static String getElement(ArrayDeque<Integer> queue, int num) {
        int smallest = Integer.MAX_VALUE;
        if (queue.isEmpty()){
            return "0";
        }else {
            while (!queue.isEmpty()){
                int n = queue.poll();
                if (smallest > n ){
                    smallest = n;
                }
                if (n == num){
                    return "true";
                }
            }
        }
        return String.valueOf(smallest);
    }
}
