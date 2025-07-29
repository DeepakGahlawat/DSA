

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow up: Could you solve the problem in linear time and in O(1) space?



import java.util.*;

class MajorityElementWithoutMap {
    public List<Integer> majorityElement(int[] nums) {
        // Using Boyer-Moore Majority Voting Algorithm for n/3
        List<Integer> ans = new ArrayList<>();
        int firstMajority = -1;
        int secondMajority = -1;
        int count1 = 0, count2 = 0;
        int n = nums.length;

        // Step 1: Find potential candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == firstMajority) {
                count1++;
            } else if (nums[i] == secondMajority) {
                count2++;
            } else if (count1 == 0) {
                firstMajority = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                secondMajority = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Count actual occurrences
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == firstMajority) count1++;
            else if (nums[i] == secondMajority) count2++;
        }

        // Step 3: Add to result if count > n/3
        if (count1 > n / 3) ans.add(firstMajority);
        if (count2 > n / 3) ans.add(secondMajority);

        return ans;
    }

    // Main method to test your function
    public static void main(String[] args) {
        MajorityElementWithoutMap  sol = new MajorityElementWithoutMap();
        int[] nums = {3, 2, 3};  // Sample input
        List<Integer> result = sol.majorityElement(nums);
        System.out.println("Majority elements (more than n/3 times): " + result);
    }
}
