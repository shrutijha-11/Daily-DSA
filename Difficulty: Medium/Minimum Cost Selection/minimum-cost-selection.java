class Solution {
    public int minCost(int[][] mat) {
        // code here
        int n = mat.length;
        
        // Cost of completing rows 0..i with each final choice
        int prev0 = mat[0][0];
        int prev1 = mat[0][1];
        int prev2 = mat[0][2];
        
        for (int i = 1; i < n; i++) {
            int cur0 = mat[i][0] + Math.min(prev1, prev2);
            int cur1 = mat[i][1] + Math.min(prev0, prev2);
            int cur2 = mat[i][2] + Math.min(prev0, prev1);
            
            prev0 = cur0;
            prev1 = cur1;
            prev2 = cur2;
        }
        
        return Math.min(prev0, Math.min(prev1, prev2));
    }
}