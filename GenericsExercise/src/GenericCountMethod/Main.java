package GenericCountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Count<Double> strings = new Count<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            double str = Double.parseDouble(br.readLine());
            strings.add(str);
        }
        Double doubleToCompare = Double.parseDouble(br.readLine());
        System.out.println(strings.countElements(doubleToCompare));
    }
}
