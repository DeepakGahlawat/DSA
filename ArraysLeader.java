// You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

// Examples:

// Input: arr = [16, 17, 4, 3, 5, 2]
// Output: [17, 5, 2]
// Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
// Input: arr = [10, 4, 2, 4, 1]
// Output: [10, 4, 4, 1]
// Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
// Input: arr = [5, 10, 20, 40]
// Output: [40]
// Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
// Input: arr = [30, 10, 10, 5]
// Output: [30, 10, 10, 5]
// Explanation: When an array is sorted in non-increasing order, all elements are leaders.
// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 106




import java.util.*;

class ArraysLeader {

    // Method to find leaders in the array
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int leader = arr[n - 1];
        ans.add(leader); // The last element is always a leader

        // Traverse from right to left to find leaders
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= leader) {
                ans.add(arr[i]);
                leader = arr[i];
            }
        }

        // Reverse the result list to maintain the original left-to-right order
        int low = 0;
        int high = ans.size() - 1;
        while (low < high) {
            int temp = ans.get(low);
            ans.set(low, ans.get(high));
            ans.set(high, temp);
            low++;
            high--;
        }

        return ans;
    }

    // Main method to run and test the leaders function
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2}; // Sample input
        ArrayList<Integer> result = leaders(arr);

        // Printing the result
        System.out.println("Leaders in the array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

