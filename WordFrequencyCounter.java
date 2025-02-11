import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String paragraph) {
        // Splitting the input string into words based on spaces
        String[] words = paragraph.split("\\s+");

        // HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Looping through each word in the array
        for (String word : words) {
            // If the word is already in the map, increase its count
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        // Test input
        String paragraph = "the cat and the hat";
        
        // Getting word frequencies
        Map<String, Integer> wordCounts = countWords(paragraph);

        // Printing the result
        System.out.println(wordCounts);  // Output: {the=2, cat=1, and=1, hat=1}
    }
}
