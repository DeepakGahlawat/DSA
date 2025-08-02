// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Examples: 

// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
// Input: arr[] = [5, 6, 7, 8, 9], k = 5
// Output: 2
// Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
// Input: arr[] = [1, 1, 1, 1], k = 0
// Output: 4
// Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
// Constraints:

// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤105
// 0 ≤ k ≤ 105

    


import java.util.*;

class CountSubarraysWithGivenXOR {
    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        int n = arr.length;
        int preXOR = 0;
        // using hashMap to store freq for prefixXOR
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);

        for (int i = 0; i < n; i++) {
            preXOR ^= arr[i];
            int check = preXOR ^ k;
            count += hm.getOrDefault(check, 0);
            hm.put(preXOR, hm.getOrDefault(preXOR, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithGivenXOR sol = new CountSubarraysWithGivenXOR();
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        long result = sol.subarrayXor(arr, k);
        System.out.println("Number of subarrays with XOR = " + k + " is: " + result);
    }
}
