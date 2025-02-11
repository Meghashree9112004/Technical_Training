import java.util.Arrays;

public class SalesPrefixSum {
    // Method to compute the prefix sum of the given sales array
    public static int[] computePrefixSum(int[] sales){
        int n = sales.length;
        int[] prefixSum = new int[n];

        // First element remains the same
        prefixSum[0] = sales[0];

        // Computing prefix sum for each hour
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + sales[i];
        }

        return prefixSum;
    }

    public static void main(String[] args) {
        // Example sales data for each hour
        int[] sales = {10, 20, 15, 30, 25};

        // Compute prefix sum
        int[] prefixSum = computePrefixSum(sales);

        // Printing the result
        System.out.println("Sales Array: " + Arrays.toString(sales));
        System.out.println("Prefix Sum: " + Arrays.toString(prefixSum));
    }
}