import java.util.Arrays;
public class PostfixSumCalculator {
    // Method to compute the postfix sum of the fuel consumption array
    public static int[] computePostfixSum(int[] fuel){
        int m = fuel.length;
        int[] postfixSum = new int[m];

        // Last element remains the same
        postfixSum[m - 1] = fuel[m - 1];

        // Computing postfix sum from right to left
        for (int i = m - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i + 1] + fuel[i];
        }

        return postfixSum;
    }

    public static void main(String[] args) {
        // Example fuel consumption data at each delivery point
        int[] fuel = {5, 10, 3, 7, 8};

        // Computing postfix sum
        int[] postfixSum = computePostfixSum(fuel);

        // Printing the results
        System.out.println("Fuel Consumption Array: " + Arrays.toString(fuel));
        System.out.println("Postfix Sum: " + Arrays.toString(postfixSum));
    }
}