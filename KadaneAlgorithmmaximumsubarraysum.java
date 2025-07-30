// Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

class KadaneAlgorithmmaximumsubarraysum{
    // Function to find the maximum sum of a contiguous subarray
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;  // To store the final result (max sum)
        int maxEndingSum = 0;         // Current subarray sum

        for (int i = 0; i < nums.length; i++) {
            // Choose maximum between starting new subarray at nums[i]
            // or extending previous subarray
            maxEndingSum = Math.max(maxEndingSum + nums[i], nums[i]);
            res = Math.max(res, maxEndingSum);  // Update result if needed
        }

        return res;
    }

    // Main method to test maxSubArray function
    public static void main(String[] args) {
        KadaneAlgorithmmaximumsubarraysum sol = new KadaneAlgorithmmaximumsubarraysum();

        // Example input
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Call the function
        int result = sol.maxSubArray(nums);

        // Print the result
        System.out.println("Maximum subarray sum is: " + result);
    }
}

