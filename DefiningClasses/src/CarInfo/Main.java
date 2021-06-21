package CarInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carData = bufferedReader.readLine().split("\\s+");
            Car car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
