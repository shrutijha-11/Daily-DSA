class Solution {
    static final long MOD = 1_000_000_007L;

    public int prefixStrings(int n) {
        // code here
        if (n == 0) return 1;

        int N = 2 * n;
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // C(2n, n) = fact[2n] / (fact[n] * fact[n])
        long denominator = fact[n] * fact[n] % MOD;
        long binomial = fact[N] * modInverse(denominator, MOD) % MOD;

        // Catalan number = C(2n, n) / (n + 1)
        long catalan = binomial * modInverse(n + 1, MOD) % MOD;

        return (int) catalan;
    }
    private long power(long a, long b, long mod) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem (mod must be prime)
    private long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }
}