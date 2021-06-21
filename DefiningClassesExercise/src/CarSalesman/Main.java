package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split("\\s+");
            Engine engine = new Engine(data[0], Integer.parseInt(data[1]));
            if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    engine.setDisplacement(data[2]);
                } else {
                    engine.setEfficiency(data[2]);
                }
            }else if (data.length == 4){
                engine.setDisplacement(data[2]);
                engine.setEfficiency(data[3]);
            }
            engines.put(data[0], engine);
        }
        List<Car> cars = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split("\\s+");
            String carModel = data[0];
            String engineModel = data[1];

            Car car = new Car(carModel, engines.get(engineModel));
            if (data.length == 3){
                if (Character.isDigit(data[2].charAt(0))){
                    car.setWeight(data[2]);
                }else {
                    car.setColor(data[2]);
                }
            }else if (data.length == 4){
                car.setWeight(data[2]);
                car.setColor(data[3]);
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
