// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

// Example 1:

// Input: g = [1,2,3], s = [1,1]
// Output: 1
// Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
// And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
// You need to output 1.
// Example 2:

// Input: g = [1,2], s = [1,2,3]
// Output: 2
// Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
// You have 3 cookies and their sizes are big enough to gratify all of the children, 
// You need to output 2.
 

// Constraints:

// 1 <= g.length <= 3 * 104
// 0 <= s.length <= 3 * 104
// 1 <= g[i], s[j] <= 231 - 1



import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int j = 0; // Pointer for cookies
        int i = 0; // Pointer for children
        int count = 0; // To count satisfied children

        // Loop until either all children or all cookies are processed
        while (i < g.length && j < s.length) {
            // If the current cookie can satisfy the current child
            if (g[i] <= s[j]) {
                count++; // Satisfy the child
                i++; // Move to next child
                j++; // Move to next cookie
            } else {
                j++; // Try next larger cookie
            }
        }

        return count; // Return number of content children
    }

    public static void main(String[] args) {
        AssignCookies sol = new AssignCookies();
        
        // Sample input: greed factors and cookie sizes
        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        int result = sol.findContentChildren(g, s);
        System.out.println("Number of content children: " + result);
    }
}

