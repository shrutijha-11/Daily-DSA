class Solution {
    public int maxArea(int[][] mat) {
        // code here
        int n = mat.length, m = mat[0].length;
        int[][] height = new int[n][m];
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][j] == 1)
                    height[i][j] = (i > 0) ? height[i-1][j] + 1 : 1;
                else
                    height[i][j] = 0;
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            Integer[] row = new Integer[m];
            for (int j = 0; j < m; j++) row[j] = height[i][j];
            Arrays.sort(row, Collections.reverseOrder());
            
            for (int k = 0; k < m; k++) {
                int area = row[k] * (k + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}