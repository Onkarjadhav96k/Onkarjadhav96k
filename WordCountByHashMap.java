import java.util.HashMap;
import java.util.Map;

public class WordCountByHashMap {

  public static Map<String, Integer> countWords(String input) {
    Map<String, Integer> wordCounts = new HashMap<>();
    String[] words = input.split("\\s+"); 

    for (String word : words) {
      word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
      int count = wordCounts.getOrDefault(word, 0);
      wordCounts.put(word, count + 1); 
    }

    return wordCounts;
  }

  public static void main(String[] args) {
    String input = "This is a string with repeated words.";
    Map<String, Integer> wordCounts = countWords(input);

    System.out.println("Word counts:");
    for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
