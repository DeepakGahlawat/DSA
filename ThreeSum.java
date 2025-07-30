// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
 

// Constraints:

// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105


import java.util.*;  // For List, ArrayList, Arrays

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;  // Target sum is 0 for 3Sum problem
        Arrays.sort(nums);  // Sort the array to use two-pointer technique
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > target) {
                    k--;  // Need smaller sum, move right pointer left
                } else if (sum < target) {
                    j++;  // Need larger sum, move left pointer right
                } else {
                    // Found a valid triplet
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);

                    j++;
                    k--;

                    // Skip duplicate elements for the second number
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    // Skip duplicate elements for the third number
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    // Main method to test threeSum function
    public static void main(String[] args) {
        ThreeSum  sol = new ThreeSum ();

        // Example input
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Call the function
        List<List<Integer>> result = sol.threeSum(nums);

        // Print the result
        System.out.println("Triplets that sum to 0 are:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
