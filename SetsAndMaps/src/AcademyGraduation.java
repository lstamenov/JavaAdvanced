import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            students.put(name, getAverage(grades));
        }
        students.forEach((key, value) -> System.out.println(key + " is graduated with " + value));
    }
    private static double getAverage(double[] grades){
        double grade = 0;
        for (double g : grades) {
            grade += g;
        }
        return grade / grades.length;
    }
}
