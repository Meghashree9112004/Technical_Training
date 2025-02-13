import java.util.*;

public class LongestSubstringWithoutRepeating {
    
    // Function to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // If character is already in set, remove from left until unique
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            // Add the new character and update max length
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for longest substring problem
        System.out.println("Enter a string to find the longest substring without repeating characters:");
        String inputString = scanner.nextLine();
        
        // Calling lengthOfLongestSubstring function and displaying output
        int maxLength = lengthOfLongestSubstring(inputString);
        System.out.println("Length of longest substring without repeating characters: " + maxLength);
        
        scanner.close();
    }
}
