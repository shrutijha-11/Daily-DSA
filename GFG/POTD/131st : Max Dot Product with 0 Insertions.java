class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        // code here
        int n = a.length;
        int m=b.length;
        int[][] dp = new int[n + 1][m + 1];

        int NEG = Integer.MIN_VALUE / 2;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = NEG;
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {

                // Skip current element of a (insert zero)
                dp[i][j] = dp[i - 1][j];

                // Match current elements
                dp[i][j] = Math.max(dp[i][j],
                        dp[i - 1][j - 1] + a[i - 1] * b[j - 1]);
            }
        }

        return dp[n][m];
    }
}
