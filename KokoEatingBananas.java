// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.

 

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:

// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// Example 3:

// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
 

// Constraints:

// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109


class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHours = findhours(piles, mid);

            if (totalHours <= h) {
                k = Math.min(k, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    int findhours(int[] piles, int speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int currPile = piles[i];
            hours += currPile % speed == 0 ? currPile / speed : currPile / speed + 1;
        }
        return hours;
    }

    public static void main(String[] args) {
        KokoEatingBananas sol = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11}; // Example input
        int h = 8;                   // Total hours available

        int result = sol.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}

