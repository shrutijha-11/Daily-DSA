/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        // code here
        List<Character> pathP = new ArrayList<>();
        List<Character> pathQ = new ArrayList<>();
        
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        
        // find length of common prefix (path down to LCA)
        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i).equals(pathQ.get(i))) {
            i++;
        }
        
        // build combined direction sequence for p -> LCA -> q
        List<Character> combined = new ArrayList<>();
        for (int j = pathP.size() - 1; j >= i; j--) {
            combined.add(pathP.get(j));   // reversed: going up from p to LCA
        }
        for (int j = i; j < pathQ.size(); j++) {
            combined.add(pathQ.get(j));   // going down from LCA to q
        }
        
        // count adjacent label changes
        int turns = 0;
        for (int j = 0; j + 1 < combined.size(); j++) {
            if (!combined.get(j).equals(combined.get(j + 1))) {
                turns++;
            }
        }
        
        return turns == 0 ? -1 : turns;
    }
    
    // records the L/R path from root to the node with value 'val'
    private boolean findPath(Node root, int val, List<Character> path) {
        if (root == null) return false;
        if (root.data == val) return true;
        
        path.add('L');
        if (findPath(root.left, val, path)) return true;
        
        path.set(path.size() - 1, 'R');
        if (findPath(root.right, val, path)) return true;
        
        path.remove(path.size() - 1);
        return false;
    }
}
