import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of coin denominations: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        
        System.out.print("Enter the coin denominations (space-separated): ");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the amount to make change for: ");
        int amount = scanner.nextInt();
        
        int result = minCoins(coins, amount);
        if (result == -1) {
            System.out.println("Change cannot be made with the given denominations.");
        } else {
            System.out.println("Minimum coins required: " + result);
        }
        
        scanner.close();
    }
}
