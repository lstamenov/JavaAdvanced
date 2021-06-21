import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputCapitals.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            line = line.toUpperCase();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
