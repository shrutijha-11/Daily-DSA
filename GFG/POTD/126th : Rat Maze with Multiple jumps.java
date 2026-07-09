class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        // code here
        int n = mat.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (n == 1) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            ans.add(row);
            return ans;
        }

        int[][] path = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        if (mat[0][0] == 0 || !dfs(0, 0, mat, path, vis, n)) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            ans.add(row);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    private boolean dfs(int r, int c, int[][] mat,
                        int[][] path, boolean[][] vis, int n) {

        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }

        if (r < 0 || c < 0 || r >= n || c >= n ||
            mat[r][c] == 0 || vis[r][c]) {
            return false;
        }

        vis[r][c] = true;
        path[r][c] = 1;

        for (int step = 1; step <= mat[r][c]; step++) {

            // Right first
            if (dfs(r, c + step, mat, path, vis, n))
                return true;

            // Then Down
            if (dfs(r + step, c, mat, path, vis, n))
                return true;
        }

        path[r][c] = 0;
        return false;
    }
}
