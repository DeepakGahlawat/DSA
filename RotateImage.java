// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

// Constraints:

// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000



import java.util.Arrays;

class RotateImage {
    public void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix[i].length - 1;
            while (low < high) {
                int tem = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = tem;
                low++;
                high--;
            }
        }
    }

    // Main method to test the rotate function
    public static void main(String[] args) {
        RotateImage sol = new RotateImage();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original matrix:");
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        sol.rotate(matrix);

        System.out.println("\nMatrix after 90-degree clockwise rotation:");
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}

