class Solution {

    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        long[][] dp = new long[mx + 1][mx + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] ndp = new long[mx + 1][mx + 1];

            for (int g1 = 0; g1 <= mx; g1++) {
                for (int g2 = 0; g2 <= mx; g2++) {
                    long cur = dp[g1][g2];
                    if (cur == 0) continue;

                    // Ignore x
                    ndp[g1][g2] = (ndp[g1][g2] + cur) % MOD;

                    // Put in seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    ndp[ng1][g2] = (ndp[ng1][g2] + cur) % MOD;

                    // Put in seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    ndp[g1][ng2] = (ndp[g1][ng2] + cur) % MOD;
                }
            }

            dp = ndp;
        }

        long ans = 0;
        for (int g = 1; g <= mx; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
