class Solution {
    static final int MOD = 1_000_000_007;

    public int computeValue(int n) {
        // code here
            int N = 2 * n;
        
        // Precompute factorials up to 2n
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // C(2n, n) = fact[2n] / (fact[n] * fact[n])
        long numerator = fact[N];
        long denom = (fact[n] * fact[n]) % MOD;
        long denomInverse = modInverse(denom, MOD);
        
        long result = (numerator * denomInverse) % MOD;
        return (int) result;
    }
    
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    
    private long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }
}
