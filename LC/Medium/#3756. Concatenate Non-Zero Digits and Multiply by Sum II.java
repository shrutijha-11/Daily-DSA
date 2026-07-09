class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] pow10 = new long[n + 1];
        long[] invPow10 = new long[n + 1];
        long[] prefVal = new long[n + 1];
        int[] prefCnt = new int[n + 1];
        int[] prefSum = new int[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        long inv10 = modPow(10, MOD - 2);
        invPow10[0] = 1;
        for (int i = 1; i <= n; i++)
            invPow10[i] = (invPow10[i - 1] * inv10) % MOD;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            prefCnt[i + 1] = prefCnt[i];
            prefSum[i + 1] = prefSum[i];
            prefVal[i + 1] = prefVal[i];

            if (c != '0') {
                int d = c - '0';
                prefCnt[i + 1]++;
                prefSum[i + 1] += d;
                prefVal[i + 1] = (prefVal[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int cnt = prefCnt[r + 1] - prefCnt[l];
            int sum = prefSum[r + 1] - prefSum[l];

            long left = (prefVal[l] * pow10[cnt]) % MOD;
            long x = (prefVal[r + 1] - left + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    private long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
