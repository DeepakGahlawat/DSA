// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

// Examples:

// Input: arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
// Output: [[1, 4], [6, 8], [9, 10]]
// Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging will become [1, 4]. Therefore we will return [[1, 4], [6, 8], [9, 10]].
// Input: arr[][] = [[6, 8], [1, 9], [2, 4], [4, 7]]
// Output: [[1, 9]]
// Explanation: In the given intervals all the intervals overlap with the interval [1, 9]. Therefore we will return [1, 9].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ starti ≤ endi ≤ 106




import java.util.*;

class MergeOverlappingIntervals {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Step 1: Sort the intervals based on the start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int[] preInterval = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];

            if (curr[0] <= preInterval[1]) {
                // Overlapping intervals, merge them
                preInterval[0] = Math.min(preInterval[0], curr[0]);
                preInterval[1] = Math.max(preInterval[1], curr[1]);
            } else {
                // Non-overlapping interval, add the previous one and move on
                res.add(new int[]{preInterval[0], preInterval[1]});
                preInterval = curr;
            }
        }

        // Add the last interval
        res.add(new int[]{preInterval[0], preInterval[1]});

        return res;
    }

    public static void main(String[] args) {
        MergeOverlappingIntervals sol = new MergeOverlappingIntervals();

        int[][] intervals = {
            {1, 3}, {2, 4}, {5, 7}, {6, 8}
        };

        ArrayList<int[]> merged = sol.mergeOverlap(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

