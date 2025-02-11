import java.util.*;

public class StringOperations {

    // Function to count occurrences of each word in a paragraph
    public static Map<String, Integer> countWords(String paragraph) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Splitting the paragraph into words using space as a delimiter
        String[] words = paragraph.split("\\s+");

        for (String word : words) {
            // If the word is already in the map, increment its count
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    // Function to remove duplicate characters from a string
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char ch : input.toCharArray()) {
            // If character is not seen before, add it to result and mark it as seen
            if (!seen.contains(ch)) {
                result.append(ch);
                seen.add(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Testing word count function
        String paragraph = "the cat and the hat";
        Map<String, Integer> wordFrequency = countWords(paragraph);
        System.out.println("Word Count: " + wordFrequency);  // Output: {the=2, cat=1, and=1, hat=1}

        // Testing remove duplicates function
        String input = "banana";
        String output = removeDuplicates(input);
        System.out.println("Modified String: " + output);  // Output: "ban"
    }
}


