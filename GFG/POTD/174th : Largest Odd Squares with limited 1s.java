class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        // 1-indexed prefix sum
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i+1][j+1] = mat[i][j] + prefix[i][j+1] + prefix[i+1][j] - prefix[i][j];
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            
            int maxR = Math.min(Math.min(i, n - 1 - i), Math.min(j, m - 1 - j));
            
            int lo = 0, hi = maxR, ans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int s = rangeSum(prefix, i - mid, j - mid, i + mid, j + mid);
                if (s <= k) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            
            res.add(ans == -1 ? -1 : (2 * ans + 1));
        }
        
        return res;
    }
    
    private int rangeSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2+1][c2+1] - prefix[r1][c2+1] - prefix[r2+1][c1] + prefix[r1][c1];
    }
}
