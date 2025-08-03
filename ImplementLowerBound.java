// Given a sorted array arr[] and a number target, the task is to find the lower bound of the target in this given array. The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal to the given number.

// Note: If all the elements in the given array are smaller than the target, the lower bound will be the length of the array. 

// Examples :

// Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
// Output: 3
// Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.
// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
// Output: 4
// Explanation: 4 is the smallest index in arr[] where element (arr[4] = 11) is greater than or equal to 11.
// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
// Output: 7
// Explanation: As no element in arr[] is greater than 100, return the length of array.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ target ≤ 106



class ImplementLowerBound {
    int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int lowestBound = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                lowestBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowestBound;
    }

    public static void main(String[] args) {
        ImplementLowerBound sol = new ImplementLowerBound();
        int[] arr = {1, 2, 4, 4, 5, 7, 9}; // Sample input
        int target = 4;

        int result = sol.lowerBound(arr, target);
        System.out.println("Lower bound index: " + result);
    }
}

