import java.util.Arrays;

public class NextGreaterElement {

    // Recursive function to find the next greater element for each index
    private static void findNextGreater(int[] arr, int[] result, int index) {
        // Base case: if we reach the last element, set it to -1 as there's no next greater element
        if (index >= arr.length) {
            return;
        }

        // Initialize next greater as -1 (default value if no greater element is found)
        int nextGreater = -1;

        // Check elements to the right to find the next greater element
        for (int j = index + 1; j < arr.length; j++) {
            if (arr[j] > arr[index]) {
                nextGreater = arr[j];
                break; // Stop at the first greater element
            }
        }

        // Store the found next greater element in the result array
        result[index] = nextGreater;

        // Recursive call for the next index
        findNextGreater(arr, result, index + 1);
    }

    // Wrapper function to call the recursive method
    public static int[] nextGreaterElements(int[] arr) {
        int[] result = new int[arr.length];

        // Start recursion from index 0
        findNextGreater(arr, result, 0);

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {6, 8, 0, 1, 3};
        int[] arr2 = {1, 3, 2, 4};
        int[] arr3 = {10, 20, 30, 50};
        int[] arr4 = {50, 40, 30, 10};

        // Printing results
        System.out.println(Arrays.toString(nextGreaterElements(arr1)));
        System.out.println(Arrays.toString(nextGreaterElements(arr2))); 
        System.out.println(Arrays.toString(nextGreaterElements(arr3))); 
        System.out.println(Arrays.toString(nextGreaterElements(arr4))); 
    }
}
