class Solution {
        static final int MOD = 1000000007;

    public static int countWays(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        long[][] dp = new long[n + 1][m + 1];

        // Empty string can always be formed
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
            }
        }

        return (int) dp[n][m];
    }
}
