// Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
// Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 


// Example 1:

// Input: N = 43
// Output: 20 20 2 1
// Explaination: 
// Minimum number of coins and notes needed 
// to make 43. 

// Example 2:

// Input: N = 1000
// Output: 500 500
// Explaination: minimum possible notes
// is 2 notes of 500.


import java.util.*;

class MinimumCoins {
    static List<Integer> minPartition(int N) {
        // Result list to store selected denominations
        ArrayList<Integer> res = new ArrayList<>();
        
        // Indian currency denominations in increasing order
        int[] currencydenomination = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        
        int j = 9; // Start from the largest denomination (2000)

        // While there is value left to partition
        while (N > 0) {
            if (N >= currencydenomination[j]) {
                // If current denomination fits, use it
                res.add(currencydenomination[j]);
                N = N - currencydenomination[j]; // Reduce the amount
            } else {
                j--; // Move to next smaller denomination
            }
        }

        return res; // Return list of denominations used
    }

    public static void main(String[] args) {
        int amount = 2753;

        // Call minPartition to get the result
        List<Integer> result = minPartition(amount);

        // Print the result
        System.out.println("Minimum currency denominations for amount " + amount + ":");
        for (int note : result) {
            System.out.print(note + " ");
        }
    }
}
