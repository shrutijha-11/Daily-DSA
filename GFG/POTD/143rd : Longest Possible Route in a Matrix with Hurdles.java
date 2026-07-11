class Solution {
    
        int max;

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here

        int n = mat.length;
        int m = mat[0].length;

        // If source or destination is blocked
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        max = -1;
        boolean[][] vis = new boolean[n][m];

        dfs(mat, xs, ys, xd, yd, vis, 0);

        return max;
    }

    private void dfs(int[][] mat, int x, int y, int xd, int yd,
                     boolean[][] vis, int dist) {

        if (x == xd && y == yd) {
            max = Math.max(max, dist);
            return;
        }

        vis[x][y] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nx = x + dr[k];
            int ny = y + dc[k];

            if (isValid(mat, nx, ny, vis)) {
                dfs(mat, nx, ny, xd, yd, vis, dist + 1);
            }
        }

        vis[x][y] = false; // Backtracking
    }

    private boolean isValid(int[][] mat, int x, int y, boolean[][] vis) {

        return x >= 0 && x < mat.length &&
               y >= 0 && y < mat[0].length &&
               mat[x][y] == 1 &&
               !vis[x][y];
    }
}
