/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int result=0;
    int maxDiff(Node root) {
        //  code here
        result = Integer.MIN_VALUE;
        dfs(root, Integer.MIN_VALUE);
        return result;
    }
    private void dfs(Node node, int ancestorMax)
    {
        if (node == null) return;

    // Only compute candidate if there's at least one real ancestor
        if (ancestorMax != Integer.MIN_VALUE) {
            result = Math.max(result, ancestorMax - node.data);
        }

        int newAncestorMax = Math.max(ancestorMax, node.data);

        dfs(node.left, newAncestorMax);
        dfs(node.right, newAncestorMax);
    }
}