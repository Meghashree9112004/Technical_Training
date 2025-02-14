import java.util.*;

public class StockMarketMinPrice {
    
    // Function to find the minimum stock price in each rolling k-day window
    public static List<Integer> findMinPrices(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Double-ended queue to store indices

        for (int i = 0; i < prices.length; i++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from back that are greater than the current element
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                deque.pollLast();
            }

            // Add current element's index to deque
            deque.offerLast(i);

            // Store the minimum value for the window (first element in deque)
            if (i >= k - 1) {
                result.add(prices[deque.peekFirst()]);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for stock prices
        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();
        
        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Take user input for window size
        System.out.print("Enter the window size (k): ");
        int k = scanner.nextInt();

        // Validate window size
        if (k <= 0 || k > n) {
            System.out.println("Invalid window size!");
            scanner.close();
            return;
        }

        // Get the minimum stock prices for each k-day window
        List<Integer> minPrices = findMinPrices(prices, k);

        // Display the result
        System.out.println("Minimum stock prices for each " + k + "-day window: " + minPrices);

        scanner.close();
    }
}
