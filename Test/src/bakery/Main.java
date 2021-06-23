package bakery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bakery bakery = new Bakery("Test", 10);
        for (int i = 0; i < 2; i++) {
            bakery.add(new Employee(
                    scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()),
                    scanner.nextLine()
            ));
        }

        System.out.println(bakery.report());
    }
}
