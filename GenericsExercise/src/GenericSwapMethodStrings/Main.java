package GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        GenericList<String> strings = new GenericList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }
        int[] indexes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int fIndex = indexes[0];
        int sIndex = indexes[1];
        strings.swap(fIndex, sIndex);
        strings.getList()
                .forEach(s -> System.out.println(s.getClass() + ": " + s));
    }
}
