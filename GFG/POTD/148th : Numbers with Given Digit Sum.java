class Solution {
    public int countWays(int n, int sum) {
        // code here
        if (sum == 0) return -1;
        if (sum > 9 * n) return -1;

        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (i == 1 && d == 0) continue; // No leading zero

                    if (s >= d) {
                        dp[i][s] += dp[i - 1][s - d];
                    }
                }
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
};
