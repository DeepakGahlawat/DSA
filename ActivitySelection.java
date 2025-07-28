// You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.

// Examples:

// Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
// Output: 4
// Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}
// Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
// Output: 1
// Explanation: A person can perform at most one activity.
// Input: start[] = [1, 3, 2, 5], finish[] = [2, 4, 3, 6]
// Output: 3
// Explanation: A person can perform activities 0, 1 and 3.
// Constraints:
// 1 ≤ start.size() = finish.size() ≤ 2*105
// 0 ≤ start[i] ≤ finish[i] ≤ 109

import java.util.*;

// Define a class to store activity start and finish times
class Activity {
    int start;
    int finish;

    // Constructor
    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {

    // Function to return the maximum number of non-overlapping activities
    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;

        // Step 1: Create a list of Activity objects
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }

        // Step 2: Sort activities based on their finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        // Step 3: Apply greedy approach to select max activities
        int count = 1; // Always select the first activity
        int lastFinishTime = activities.get(0).finish;

        // Iterate over remaining activities
        for (int i = 1; i < n; i++) {
            // If the start time is >= finish time of last selected activity
            if (activities.get(i).start >lastFinishTime) {
                count++; // Select the activity
                lastFinishTime = activities.get(i).finish; // Update the last finish time
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] finish1 = {2, 4, 6, 7, 9, 9};
        System.out.println("Max activities: " + maxActivities(start1, finish1)); // Expected: 4

        // Test Case 2
        int[] start2 = {10, 12, 20};
        int[] finish2 = {20, 25, 30};
        System.out.println("Max activities: " + maxActivities(start2, finish2)); // Expected: 1

        // Test Case 3
        int[] start3 = {1, 3, 2, 5};
        int[] finish3 = {2, 4, 3, 6};
        System.out.println("Max activities: " + maxActivities(start3, finish3)); // Expected: 3
    }
}


