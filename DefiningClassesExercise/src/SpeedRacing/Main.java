package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            if (isSuchCar(input[0], cars) == -1){
                Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
                cars.add(car);
            }
        }

        String input = bufferedReader.readLine();
        while (!input.equals("End")){
            String[] arr = input.split("\\s+");
            int carIndex = isSuchCar(arr[1], cars);
            if (carIndex != -1){
                cars.get(carIndex).drive(Integer.parseInt(arr[2]));
            }

            input = bufferedReader.readLine();
        }
        cars
                .forEach(car -> System.out.println(car.toString()));
    }

    private static int isSuchCar(String s, List<Car> cars) {
        for (Car c : cars) {
            if (c.getModel().equals(s)){
                return cars.indexOf(c);
            }
        }
        return -1;
    }
}
