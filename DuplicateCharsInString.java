import java.util.HashMap;
import java.util.Map;

public class DuplicateCharsInString {

  public static void findDuplicates(String str) {
    HashMap<Character, Integer> charCount = new HashMap<>();

    for (char ch : str.toCharArray()) {
      int count = charCount.getOrDefault(ch, 0);
      if (count > 0) {
        System.out.println("Duplicate character: " + ch);
      }
      charCount.put(ch, count + 1);
    }
  }

  public static void main(String[] args) {
    String str = "This is a string which  with repeated characters.";
    findDuplicates(str);
  }
}
