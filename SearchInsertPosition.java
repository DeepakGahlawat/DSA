// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target)
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Index to insert " + target + ": " + sol.searchInsert(nums, target));

        target = 2;
        System.out.println("Index to insert " + target + ": " + sol.searchInsert(nums, target));

        target = 7;
        System.out.println("Index to insert " + target + ": " + sol.searchInsert(nums, target));

        target = 0;
        System.out.println("Index to insert " + target + ": " + sol.searchInsert(nums, target));
    }
}

