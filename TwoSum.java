// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

import java.util.HashMap;

class TwoSum {
    
    // Function to return indices of two numbers that sum to the target
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // Stores number -> index
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // Check if complement (target - nums[i]) is already seen
            if (hm.containsKey(target - nums[i])) {
                res[0] = hm.get(target - nums[i]); // Index of complement
                res[1] = i;                        // Current index
                return res;
            }
            hm.put(nums[i], i); // Store number and its index
        }

        return res; // In case no solution is found (based on problem constraint, this shouldn't happen)
    }

    // Main method to test the function
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = {2, 7, 11, 15}; // Example input array
        int target = 17;              // Target sum

        int[] result = ts.twoSum(nums, target); // Call twoSum

        System.out.println("Indices of two numbers that add up to target:");
        System.out.println("Index 1: " + result[0] + ", Index 2: " + result[1]);
    }
}
