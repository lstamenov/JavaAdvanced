import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resultsWordCount.txt"));
        Map<String, Integer> wordsMap = new HashMap<>();
        while(bufferedReader.ready()){
            String w = bufferedReader.readLine();
            String[] wordsArr = w.split("\\s+");

            for (String word : wordsArr) {
                wordsMap.put(word, 0);
            }
        }
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String[] wordArr = line.split("\\s+");
            for (String w : wordArr) {
                if (wordsMap.get(w) != null){
                    wordsMap.put(w, wordsMap.get(w) + 1);
                }
            }
        }
        wordsMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    try {
                        bufferedWriter.write(String.format("%s - %d", e.getKey(), e.getValue()));
                        bufferedWriter.newLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
        bufferedReader.close();
        bufferedWriter.close();
    }
}
