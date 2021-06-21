import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String vowelsTable = "aeoui";
        String punctuation = "!,.?";
        int countVowels = 0;
        int countPunctuations = 0;
        int countConsonants = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputCount.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            for (int i = 0; i < line.length(); i++) {
                if (vowelsTable.contains(String.valueOf(line.charAt(i)))){
                    countVowels++;
                }else if (punctuation.contains(String.valueOf(line.charAt(i)))){
                    countPunctuations++;
                }else {
                    if (line.charAt(i) != ' '){
                        countConsonants++;
                    }
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.write(String.format("Vowels: %d", countVowels));
        bufferedWriter.newLine();
        bufferedWriter.write(String.format("Consonants: %d", countConsonants));
        bufferedWriter.newLine();
        bufferedWriter.write(String.format("Punctuation: %d", countPunctuations));
        bufferedWriter.close();
    }
}
