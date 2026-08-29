class Solution {
    public int countSubsequences(String s, int n) {
        // code here
        final int MOD = 1_000_000_007;
        long[] dp = new long[n]; // dp[r] = count of subsequences with value % n == r

        for (char ch : s.toCharArray()) {
            int d = ch - '0';
            long[] newDp = dp.clone(); // subsequences that skip this digit

            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int nr = (int) ((r * 10L + d) % n);
                    newDp[nr] = (newDp[nr] + dp[r]) % MOD;
                }
            }

            int dAlone = d % n;
            newDp[dAlone] = (newDp[dAlone] + 1) % MOD; // digit d by itself

            dp = newDp;
        }

        return (int) (dp[0] % MOD);
    }
}
