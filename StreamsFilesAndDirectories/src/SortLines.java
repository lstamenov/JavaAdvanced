import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("/home/lyubomir/Documents/JavaAdvanced/input5.txt");
        Path output = Paths.get("output5.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(output)));
        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        for (String line : lines) {
            bufferedWriter.write(line);
            bufferedWriter.write('\n');
        }
        bufferedWriter.flush();
    }
}
