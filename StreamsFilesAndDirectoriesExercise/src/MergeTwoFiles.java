import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("mergedOutput.txt"));
        while (bufferedReader1.ready() || bufferedReader2.ready()){
            if (bufferedReader1.ready()){
                String line = bufferedReader1.readLine();
                bufferedWriter.write(line);
            }else {
                String line = bufferedReader2.readLine();
                bufferedWriter.write(line);
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader1.close();
        bufferedReader2.close();
    }
}
