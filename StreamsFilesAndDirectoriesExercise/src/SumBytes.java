import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BigInteger bigInteger = new BigInteger(String.valueOf(BigInteger.valueOf(0)));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            long sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            bigInteger = bigInteger.add(BigInteger.valueOf(sum));
        }
        bufferedReader.close();
        System.out.println(bigInteger);
    }
//    //    /home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt
}
