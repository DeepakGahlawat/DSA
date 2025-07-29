
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

import java.util.*;

class MajorityElementsWithMap {

    // Method to find all elements that appear more than n/3 times
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Count frequency of each element in the array
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i]) + 1);
            else
                hm.put(nums[i], 1);
        }

        // Check for elements with frequency > n/3
        for (Map.Entry<Integer, Integer> mapElement : hm.entrySet()) {
            if (mapElement.getValue() > n / 3)
                ans.add(mapElement.getKey());
        }

        return ans;
    }

    // Main method to run and test the above function
    public static void main(String[] args) {
       MajorityElementsWithMap sol = new MajorityElementsWithMap();

        // Example input
        int[] nums = {3, 2, 3, 1, 2, 2, 3};

        // Call the majorityElement method
        List<Integer> result = sol.majorityElement(nums);

        // Print the result
        System.out.println("Elements appearing more than n/3 times: " + result);
    }
}
