import java.util.*;

public class UniqueDigitsFinder{
    public static void main(String[] args){
        // Example input array
        int[] numbers = {111, 222, 333, 4444, 666};

        // Create a set to store unique digits
        Set<Integer> uniqueDigits = new TreeSet<>(); // TreeSet keeps numbers sorted

        // Go through each number in the array
        for (int num : numbers) {
            while (num > 0) {
                int digit = num % 10; // Get the last digit
                uniqueDigits.add(digit); // Add it to the set
                num = num / 10; // Remove the last digit
            }
        }

        // Printing the unique sorted digits
        System.out.println("Unique Digits: " + uniqueDigits);
    }
}