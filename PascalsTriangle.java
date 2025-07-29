// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30


import java.util.*;

class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(); // Final list to hold all rows of Pascal's Triangle

        // First row is always [1]
        List<Integer> fir = new ArrayList<>();
        fir.add(1);
        ans.add(fir);

        // If only 1 row is needed, return
        if (numRows == 1)
            return ans;

        // Second row is always [1, 1]
        List<Integer> sec = new ArrayList<>();
        sec.add(1);
        sec.add(1);
        ans.add(sec);

        int j = 2; // Start building rows from index 2 (3rd row)
        while (j < numRows) {
            List<Integer> newRowList = new ArrayList<>();
            newRowList.add(1); // First element is always 1

            int prevRowSize = ans.get(j - 1).size();
            int a = 0;
            int b = 1;

            // Calculate the middle elements using previous row
            while (b < prevRowSize) {
                newRowList.add(ans.get(j - 1).get(a) + ans.get(j - 1).get(b));
                a++;
                b++;
            }

            newRowList.add(1); // Last element is always 1
            ans.add(newRowList); // Add the row to result
            j++;
        }

        return ans;
    }

    // Main method to test the generate function
    public static void main(String[] args) {
        PascalsTriangle sol = new PascalsTriangle();
        int numRows = 5;

        // Generate Pascal's Triangle
        List<List<Integer>> triangle = sol.generate(numRows);

        // Print each row
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
