// You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

// Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

// Examples:

// Input: coins[] = [25, 10, 5], sum = 30
// Output: 2
// Explanation: Minimum 2 coins needed, 25 and 5  
// Input: coins[] = [9, 6, 5, 1], sum = 19
// Output: 3
// Explanation: 19 = 9 + 9 + 1
// Input: coins[] = [5, 1], sum = 0
// Output: 0
// Explanation: For 0 sum, we do not need a coin
// Input: coins[] = [4, 6, 2], sum = 5
// Output: -1
// Explanation: Not possible to make the given sum.
 
// Constraints:
// 1 ≤ sum * coins.size() ≤ 106
// 0 <= sum <= 104
// 1 <= coins[i] <= 104
// 1 <= coins.size() <= 103

import java.util.*;

class CoinChangeDP {

    public int minCoins(int coins[], int sum) {
        // Create a memoization table, filled with -1 (indicating uncomputed states)
        int[][] dp = new int[coins.length][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int res = minCoinsHelper(0, sum, coins, dp);

        // If result is MAX_VALUE, it means no valid combination was found
        return res != Integer.MAX_VALUE ? res : -1;
    }

    // Recursive helper function with memoization
    int minCoinsHelper(int i, int sum, int[] coins, int[][] dp) {
        // Base case: If sum is 0, no coins are needed
        if (sum == 0) return 0;

        // If sum becomes negative or no coins left, return MAX (invalid path)
        if (sum < 0 || i == coins.length) return Integer.MAX_VALUE;

        // Return previously computed result
        if (dp[i][sum] != -1) return dp[i][sum];

        int take = Integer.MAX_VALUE;

        // Try taking the current coin (only if it's valid)
        if (coins[i] > 0) {
            take = minCoinsHelper(i, sum - coins[i], coins, dp); // Don't move to next coin
            if (take != Integer.MAX_VALUE) take++; // Count the coin used
        }

        // Try skipping the current coin
        int noTake = minCoinsHelper(i + 1, sum, coins, dp);

        // Store the minimum of take and noTake in dp table
        dp[i][sum] = Math.min(take, noTake);

        return dp[i][sum];
    }

    // Main method for testing
    public static void main(String[] args) {
        CoinChangeDP sol = new CoinChangeDP();

        // Example test case
        int[] coins = {9, 6, 5, 1};
        int sum = 19;

        int result = sol.minCoins(coins, sum);
        System.out.println("Minimum coins required to make sum " + sum + ": " + result);
    }
}

