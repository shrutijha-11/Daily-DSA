/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
        // code here
    private int maxLen = 1;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;
        dfs(root);
        return maxLen > 1 ? maxLen : -1;
    }

    // Returns length of the longest increasing-by-1 chain starting at `node`.
    private int dfs(Node node) {
        if (node == null) return 0;

        int leftLen = dfs(node.left);
        int rightLen = dfs(node.right);

        int curLeft = 1;
        int curRight = 1;

        if (node.left != null && node.left.data == node.data + 1) {
            curLeft = leftLen + 1;
        }
        if (node.right != null && node.right.data == node.data + 1) {
            curRight = rightLen + 1;
        }

        int best = Math.max(curLeft, curRight);
        maxLen = Math.max(maxLen, best);
        return best;
    }
}
