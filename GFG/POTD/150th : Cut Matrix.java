class Solution {
    static final int MOD = 1_000_000_007;
    public int findWays(int[][] matrix, int k) {
        // code here
        int R = matrix.length, C = matrix[0].length;

        // 1. Prefix sums for O(1) rectangle-sum queries
        int[][] pre = new int[R + 1][C + 1];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + matrix[i][j];

        // 2. Precompute rowThresh[i][j]: minimal r in [i+1, R-1] such that
        //    rows[i..r-1] x cols[j..C-1] contains a 1; sentinel = R if none.
        int[][] rowThresh = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int lo = i + 1, hi = R - 1, ans = R;
                while (lo <= hi) {
                    int mid = (lo + hi) >>> 1;
                    if (hasOne(pre, i, j, mid - 1, C - 1)) {
                        ans = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                rowThresh[i][j] = ans;
            }
        }

        // 3. Precompute colThresh[i][j]: minimal c in [j+1, C-1] such that
        //    rows[i..R-1] x cols[j..c-1] contains a 1; sentinel = C if none.
        int[][] colThresh = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int lo = j + 1, hi = C - 1, ans = C;
                while (lo <= hi) {
                    int mid = (lo + hi) >>> 1;
                    if (hasOne(pre, i, j, R - 1, mid - 1)) {
                        ans = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                colThresh[i][j] = ans;
            }
        }

        // 4. DP base case: p = 1
        long[][] dpPrev = new long[R][C];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                dpPrev[i][j] = hasOne(pre, i, j, R - 1, C - 1) ? 1L : 0L;

        if (k == 1) return (int) (dpPrev[0][0] % MOD);

        long[][] dpCur = new long[R][C];
        // colSuffix[j][i] = dpPrev[i][j] + dpPrev[i+1][j] + ... + dpPrev[R-1][j]
        long[][] colSuffix = new long[C][R + 1];
        // rowSuffix[i][j] = dpPrev[i][j] + dpPrev[i][j+1] + ... + dpPrev[i][C-1]
        long[][] rowSuffix = new long[R][C + 1];

        for (int p = 2; p <= k; p++) {
            // build suffix sums from dpPrev
            for (int j = 0; j < C; j++) {
                colSuffix[j][R] = 0;
                for (int i = R - 1; i >= 0; i--)
                    colSuffix[j][i] = (colSuffix[j][i + 1] + dpPrev[i][j]) % MOD;
            }
            for (int i = 0; i < R; i++) {
                rowSuffix[i][C] = 0;
                for (int j = C - 1; j >= 0; j--)
                    rowSuffix[i][j] = (rowSuffix[i][j + 1] + dpPrev[i][j]) % MOD;
            }

            for (int i = R - 1; i >= 0; i--) {
                for (int j = C - 1; j >= 0; j--) {
                    long total = 0;
                    // horizontal cuts: sum dpPrev[r][j] for r from rowThresh[i][j] to R-1
                    total = (total + colSuffix[j][rowThresh[i][j]]) % MOD;
                    // vertical cuts: sum dpPrev[i][c] for c from colThresh[i][j] to C-1
                    total = (total + rowSuffix[i][colThresh[i][j]]) % MOD;
                    dpCur[i][j] = total;
                }
            }

            // swap dpPrev <-> dpCur for next iteration
            long[][] tmp = dpPrev;
            dpPrev = dpCur;
            dpCur = tmp;
        }

        return (int) (dpPrev[0][0] % MOD);
    }

    private boolean hasOne(int[][] pre, int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2) return false;
        int sum = pre[r2 + 1][c2 + 1] - pre[r1][c2 + 1] - pre[r2 + 1][c1] + pre[r1][c1];
        return sum > 0;
    }
}
