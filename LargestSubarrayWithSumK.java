// Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

// Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

// Examples:

// Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5
// Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
// Input: arr[] = [2, 10, 4]
// Output: 0
// Explanation: There is no subarray with a sum of 0.
// Input: arr[] = [1, 0, -4, 3, 1, 0]
// Output: 5
// Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
// Constraints:
// 1 ≤ arr.size() ≤ 106
// −103 ≤ arr[i] ≤ 103

import java.util.*;

class LargestSubarrayWithSumK {
    int maxLength(int arr[]) {
        // code here
        int k = 0;
        int preSum = 0;
        int maxLength = 0;
        // using hash map to store prefix sum and first Index
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (hm.containsKey(preSum)) {
                int len = i - hm.getOrDefault(preSum, 0);
                maxLength = Math.max(maxLength, len);
            } else {
                hm.put(preSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LargestSubarrayWithSumK  sol = new LargestSubarrayWithSumK();
        int[] arr = {1, 2, -3, 3, -1, 2, -2};
        int result = sol.maxLength(arr);
        System.out.println("Maximum length of subarray with sum 0 is: " + result);
    }
}


