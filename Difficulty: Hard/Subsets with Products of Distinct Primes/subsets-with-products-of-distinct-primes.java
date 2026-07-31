class Solution {
        // code here
    static final int MOD = 1_000_000_007;


    public int countSubsets(int[] arr) {
        Map<Integer, Integer> primeIndex = new HashMap<>();
        List<Integer> masks = new ArrayList<>();
        long onesMultiplier = 1;

        for (int val : arr) {
            if (val == 1) {
                onesMultiplier = (onesMultiplier * 2) % MOD;
                continue;
            }

            int x = val;
            boolean squareFree = true;
            Set<Integer> primesUsed = new HashSet<>();

            for (int p = 2; (long) p * p <= x; p++) {
                if (x % p == 0) {
                    int cnt = 0;
                    while (x % p == 0) { x /= p; cnt++; }
                    if (cnt > 1) { squareFree = false; break; }
                    primesUsed.add(p);
                }
            }
            if (!squareFree) continue;   // has a repeated prime factor -> can't be used
            if (x > 1) primesUsed.add(x); // remaining leftover prime factor (exponent 1)

            int mask = 0;
            for (int p : primesUsed) {
                primeIndex.putIfAbsent(p, primeIndex.size());
                mask |= (1 << primeIndex.get(p));
            }
            masks.add(mask);
        }

        int k = primeIndex.size();
        int size = 1 << k;
        long[] dp = new long[size];
        dp[0] = 1;

        for (int mask : masks) {
            for (int m = size - 1; m >= 0; m--) {
                if (dp[m] == 0) continue;
                if ((m & mask) == 0) {
                    dp[m | mask] = (dp[m | mask] + dp[m]) % MOD;
                }
            }
        }

        long total = 0;
        for (int m = 1; m < size; m++) {
            total = (total + dp[m]) % MOD;
        }

        total = (total * onesMultiplier) % MOD;
        return (int) total;
    }
}