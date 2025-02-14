import java.util.Scanner;

public class PermutationInString {
    // Function to check if s2 contains a permutation of s1
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        
        // If s1 is longer than s2, it is not possible to have a permutation
        if (len1 > len2) return false;

        // Frequency arrays to track character counts in sliding window
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Populate frequency array for s1 and first 'len1' characters of s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (matches(s1Count, s2Count)) return true;

        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add new character to window
            s2Count[s2.charAt(i) - 'a']++;
            // Remove the leftmost character from window
            s2Count[s2.charAt(i - len1) - 'a']--;

            // Check if current window matches
            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    // Function to check if two frequency arrays match
    private static boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for s1
        System.out.print("Enter first string (s1): ");
        String s1 = scanner.next();

        // Take user input for s2
        System.out.print("Enter second string (s2): ");
        String s2 = scanner.next();

        // Call function to check for permutation in substring
        boolean result = checkInclusion(s1, s2);

        // Print result
        if (result) {
            System.out.println("Yes, s2 contains a permutation of s1.");
        } else {
            System.out.println("No, s2 does not contain a permutation of s1.");
        }

        scanner.close();
    }
}
