// Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

// Examples:

// Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
// Output: 6
// Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
// Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
// Output: 4
// Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
// Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
// Output: 7
// Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 105




import java.util.*;

class LongestConsicutiveSubaaray {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        int longest = 1;
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsicutiveSubaaray sol = new LongestConsicutiveSubaaray();

        // Test Case 1
        int[] arr1 = {53, 57, 77, 15, 78, 58, 17, 63, 90, 73, 68, 82, 40, 68, 22, 52, 81,
                      92, 80, 37, 62, 17, 76, 67, 55, 56, 20, 22, 37, 71, 65, 7, 30, 93,
                      1, 1, 90, 46, 36, 74, 0, 37, 76, 69, 39, 97, 39, 30, 14, 89, 74,
                      71, 27, 79, 51, 45, 51, 54, 90, 35, 68, 38, 7, 82, 55, 65, 14, 40,
                      20, 64, 89, 95, 8, 43, 14, 88, 5, 24, 72, 9, 56, 17, 60, 91, 16,
                      94, 47, 15, 33};

        int result = sol.longestConsecutive(arr1);
        System.out.println("Longest consecutive subsequence length: " + result); // Expected: 8
    }
}

