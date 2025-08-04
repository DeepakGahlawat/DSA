// Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
// Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
// After 1st Rotation : [9, 2, 4, 6]
// After 2nd Rotation : [6, 9, 2, 4]

// Examples:

// Input: arr[] = [5, 1, 2, 3, 4]
// Output: 1
// Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
// Input: arr = [1, 2, 3, 4, 5]
// Output: 0
// Explanation: The given array is not rotated.
// Constraints:
// 1 ≤ arr.size() ≤105
// 1 ≤ arr[i] ≤ 107



class FindKthRotation {
    public int findKRotation(int nums[]) {
        if (nums.length == 1) return 0;
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Left half sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= min) {
                    min = nums[low];
                    index = low;
                }
                low = mid + 1;
            } else { // Right half sorted
                if (nums[mid] <= min) {
                    min = nums[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index == -1 ? 0 : index;
    }

    public static void main(String[] args) {
        FindKthRotation sol = new FindKthRotation();
        int[] nums1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println("K rotation index: " + sol.findKRotation(nums1));

        int[] nums2 = {3, 4, 5, 1, 2};
        System.out.println("K rotation index: " + sol.findKRotation(nums2));

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("K rotation index: " + sol.findKRotation(nums3));
    }
}

