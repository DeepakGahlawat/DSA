
// User function Template for Java
import java.util.*;
 class Node {
         int data;
         Node left;
         Node right;

        public Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

class Solution {
   

    public static void main(String[] args) {
		String s = "abcdef";
		int[] freq = {5, 9, 12, 13, 16, 45};
		ArrayList<String> ans = huffmanCodes(s, freq,freq.length);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
    }
    public static ArrayList<String> huffmanCodes(String S, int f[], int N) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.data < b.data)
                return -1;
            return 1;
        });
        for (int i = 0; i < N; i++) {
            pq.add(new Node(f[i]));
        }
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(left.data + right.data);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        Node root = pq.poll();
        ArrayList<String> ans = new ArrayList<>();
        String temp = "";
        preorder(root, ans, temp);
        return ans;

    }

    public static void preorder(Node root, ArrayList<String> ans, String temp) {
        if (root.left == null & root.right == null) {
            ans.add(temp);
            return;
        }
        preorder(root.left, ans, temp + "0");
        preorder(root.right, ans, temp + "1");
    }
    

}