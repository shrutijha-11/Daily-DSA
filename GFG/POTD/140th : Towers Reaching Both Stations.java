class Solution {
    
    int n, m;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int countCoordinates(int[][] mat) {
        // code here
        n = mat.length;
        m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        // Station P (Top row + Left column)
        for (int i = 0; i < n; i++)
            dfs(mat, i, 0, p);

        for (int j = 0; j < m; j++)
            dfs(mat, 0, j, p);

        // Station Q (Bottom row + Right column)
        for (int i = 0; i < n; i++)
            dfs(mat, i, m - 1, q);

        for (int j = 0; j < m; j++)
            dfs(mat, n - 1, j, q);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j])
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int[][] mat, int x, int y, boolean[][] vis) {
        if (vis[x][y]) return;

        vis[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                !vis[nx][ny] &&
                mat[nx][ny] >= mat[x][y]) {

                dfs(mat, nx, ny, vis);
            }
        }
    }
}
