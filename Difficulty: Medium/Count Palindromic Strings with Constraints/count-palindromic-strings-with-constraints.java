class Solution {
    static final long MOD = 1000000007L;

    public int palindromicStrings(int n, int k) {
        // code here
        long ans = 0;

        for (int len = 1; len <= n && len <= 2 * k + 1; len++) {

            if (len % 2 == 0) {
                // len = 2*r
                int r = len / 2;

                long ways = 1;

                // P(k, r)
                for (int i = 0; i < r; i++) {
                    ways = (ways * (k - i)) % MOD;
                }

                ans = (ans + ways) % MOD;

            } else {
                // len = 2*r + 1
                int r = len / 2;

                // Choose middle character: k ways
                // Choose and arrange r characters from remaining k-1
                long ways = k;

                // P(k-1, r)
                for (int i = 0; i < r; i++) {
                    ways = (ways * (k - 1 - i)) % MOD;
                }

                ans = (ans + ways) % MOD;
            }
        }

        return (int) ans;
    }
}