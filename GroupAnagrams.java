import java.util.*;

public class GroupAnagrams {
    
    // Function to group anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String word : strs) {
            // Convert word to character array and sort it
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            // Store in HashMap with sorted word as key
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for group anagrams problem
        System.out.println("Enter number of words:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] words = new String[n];
        
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        
        // Calling groupAnagrams function and displaying output
        List<List<String>> anagramGroups = groupAnagrams(words);
        System.out.println("Grouped Anagrams:");
        System.out.println(anagramGroups);
        
        scanner.close();
    }
}