// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
 

// Constraints:

// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109





import java.util.*;  // For List, ArrayList, Arrays

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to use two-pointer technique

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum > target) {
                        l--;  // Reduce sum by moving right pointer left
                    } else if (sum < target) {
                        k++;  // Increase sum by moving left pointer right
                    } else {
                        // Found valid quadruplet
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);

                        k++;
                        l--;

                        // Skip duplicates for the third number
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        // Skip duplicates for the fourth number
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return ans;
    }

    // Main method to test fourSum function
    public static void main(String[] args) {
        FourSum sol = new FourSum();

        // Example input
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        // Call the function
        List<List<Integer>> result = sol.fourSum(nums, target);

        // Print the result
        System.out.println("Quadruplets that sum to " + target + " are:");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}

