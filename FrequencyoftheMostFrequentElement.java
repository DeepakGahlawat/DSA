

// The frequency of an element is the number of times it occurs in an array.

// You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

// Return the maximum possible frequency of an element after performing at most k operations.

 

// Example 1:

// Input: nums = [1,2,4], k = 5
// Output: 3
// Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
// 4 has a frequency of 3.
// Example 2:

// Input: nums = [1,4,8,13], k = 5
// Output: 2
// Explanation: There are multiple optimal solutions:
// - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
// - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
// - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
// Example 3:

// Input: nums = [3,9,6], k = 2
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
// 1 <= k <= 105




import java.util.*;

class FrequencyoftheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to use sliding window on increasing values
        
        int first = 0;
        int second = 0;
        long windowSum = nums[0]; // Sum of current sliding window
        int maxfre = 0;           // Store the maximum frequency found

        while (first <= second && second < nums.length) {
            long curr = windowSum + k; // Total allowed sum after adding k
            int windowSize = second - first + 1;
            long req = (long) windowSize * nums[second]; // Required sum if all elements were nums[second]

            if (req <= curr) {
                // Valid window → update max frequency
                maxfre = Math.max(maxfre, windowSize);
                second++;
                if (second < nums.length)
                    windowSum += nums[second]; // Expand window to the right
            } else {
                // Invalid → shrink window from the left
                windowSum -= nums[first];
                first++;
            }
        }

        return maxfre;
    }

    public static void main(String[] args) {
        FrequencyoftheMostFrequentElement sol = new FrequencyoftheMostFrequentElement();

        // Sample input
        int[] nums = {1, 2, 4};
        int k = 5;

        int result = sol.maxFrequency(nums, k);
        System.out.println("Maximum frequency achievable: " + result);
    }
}
