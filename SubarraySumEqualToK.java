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


import java.util.HashMap;

class SubarraySumEqualToK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int preSum = 0;

        // HashMap to store prefix sum frequencies
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // To handle subarrays that start from index 0

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]; // Update prefix sum

            // Check if there's a prefix sum such that preSum - k = that value
            int rem = preSum - k;
            count += hm.getOrDefault(rem, 0);

            // Add/update prefix sum in the map
            hm.put(preSum, hm.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    // Main method to test the subarraySum function
    public static void main(String[] args) {
        SubarraySumEqualToK sol = new SubarraySumEqualToK();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Total subarrays with sum " + k1 + ": " + sol.subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Total subarrays with sum " + k2 + ": " + sol.subarraySum(nums2, k2)); // Output: 2
    }
}
