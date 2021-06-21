import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double grade = Double.parseDouble(data[1]);
            if (studentGrades.get(name) == null){
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                studentGrades.put(name, grades);
            }else {
                studentGrades.get(name).add(grade);
            }
        }
        studentGrades.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(s -> {
                        System.out.print(s.getKey() + " -> ");
        List<Double> value = s.getValue();
        for (double g : value) {
            System.out.printf("%.2f ", g);
        }
        OptionalDouble grade = value.stream()
                .mapToDouble(Double::doubleValue).average();
        if (grade.isPresent())
            System.out.printf("(avg: %.2f)", grade.getAsDouble());
        System.out.println();
                });
    }
}
