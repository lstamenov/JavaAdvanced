import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] open = {40, 91, 123};
        boolean isYesOrNo = false;
        String brackets = scanner.nextLine();
        ArrayDeque<Integer> bracketsStack = new ArrayDeque<>();
        for (int i = 0; i < brackets.length(); i++) {
            if (isOpen(brackets.charAt(i), open)){
                bracketsStack.push((int)brackets.charAt(i));
            }else {
                int opening = bracketsStack.pop();
                if (opening == 40){
                    if (opening + 1 != brackets.charAt(i)){
                        isYesOrNo = false;
                        System.out.println("NO");
                        break;
                    }else {
                        isYesOrNo = true;
                    }
                }else {
                    if (opening + 2 != brackets.charAt(i)){
                        isYesOrNo = false;
                        System.out.println("NO");
                        break;
                    }else {
                        isYesOrNo = true;
                    }
                }
            }
        }
        if (isYesOrNo){
            System.out.println("YES");
        }
    }

    private static boolean isOpen(char charAt, int[] nums) {
        for (int n : nums) {
            if (n == charAt){
                return true;
            }
        }
        return false;
    }
}
