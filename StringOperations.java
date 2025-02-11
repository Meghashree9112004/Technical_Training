 import java.util.LinkedHashSet;

public class RemoveDuplicateCharacters {

    public static String removeDuplicates(String input) {
        // Using LinkedHashSet to maintain order and remove duplicates
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();

        // Looping through each character in the input string
        for (char ch : input.toCharArray()) {
            uniqueChars.add(ch); // Adds only unique characters
        }

        // Building the final string without duplicates
        StringBuilder result = new StringBuilder();
        for (char ch : uniqueChars) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test input
        String input = "banana";

        // Getting the modified string
        String output = removeDuplicates(input);

        // Printing the result
        System.out.println(output); // Output: "ban"
    }
}



         
