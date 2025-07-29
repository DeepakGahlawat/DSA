// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107



import java.util.*;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sum = 0, count = 0;

        // Base case: prefix sum 0 occurs once
        mpp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // running prefix sum

            // If (sum - k) exists, that means a subarray with sum k ends here
            if (mpp.containsKey(sum - k))
                count += mpp.get(sum - k);

            // Update the frequency of current sum in the map
            int freq = 1;
            if (mpp.containsKey(sum))
                freq += mpp.get(sum);

            mpp.put(sum, freq);
        }

        return count;
    }

    public static void main(String[] args) {
       SubarraySumEqualsK sol = new SubarraySumEqualsK();

        // Example input
        int[] nums = {1, 1, 1};
        int k = 2;

        int result = sol.subarraySum(nums, k);
        System.out.println("Total number of subarrays with sum " + k + ": " + result);
    }
}
