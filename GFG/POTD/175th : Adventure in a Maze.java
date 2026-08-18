class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        final int MOD = 1_000_000_007;
        int n = grid.length;

        long[][] count = new long[n][n];
        long[][] best  = new long[n][n];

        for (long[] row : best) Arrays.fill(row, -1);

        count[0][0] = 1;
        best[0][0]  = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                long total = 0;
                long topBest = -1;

                if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3) && count[i - 1][j] > 0) {
                    total += count[i - 1][j];
                    topBest = Math.max(topBest, best[i - 1][j]);
                }

                if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 3) && count[i][j - 1] > 0) {
                    total += count[i][j - 1];
                    topBest = Math.max(topBest, best[i][j - 1]);
                }

                count[i][j] = total % MOD;
                best[i][j]  = (topBest != -1) ? topBest + grid[i][j] : -1;
            }
        }

        long finalCount = count[n - 1][n - 1];
        long finalBest  = best[n - 1][n - 1];

        // if unreachable, report 0 instead of -1
        if (finalCount == 0) finalBest = 0;

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) finalCount);
        result.add((int) finalBest);
        return result;
    }
}
