// Given an array of integers arr[]. You have to find the Inversion Count of the array. 
// Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

// Examples:

// Input: arr[] = [2, 4, 1, 3, 5]
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
// Input: arr[] = [2, 3, 4, 5, 6]
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.
// Input: arr[] = [10, 10, 10]
// Output: 0
// Explanation: As all the elements of array are same, so there is no inversion count.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 104





import java.util.*;

class CountInversion {

    static int count = 0;

    static int inversionCount(int arr[]) {
        count = 0; // Reset before each call
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                count += (mid - i + 1); // Correct inversion count
                list.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            list.add(arr[i]);
            i++;
        }

        while (j <= high) {
            list.add(arr[j]);
            j++;
        }

        for (int k = low; k <= high; k++) {
            arr[k] = list.get(k - low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int result = inversionCount(arr);
        System.out.println("Inversion Count: " + result);
    }
}

