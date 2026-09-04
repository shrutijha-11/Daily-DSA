class Solution {
    long i, d, c;
    HashMap<Long, Long> memo = new HashMap<>();

    public int minCost(int n, int i, int d, int c) {
        this.i = i;
        this.d = d;
        this.c = c;
        return (int) solve((long) n);
    }

    private long solve(long m) {
        if (m <= 0) return 0;
        if (memo.containsKey(m)) return memo.get(m);

        // Option: build m purely by inserting, no doubling at all
        long best = m * i;

        if (m >= 2) {
            long half = m / 2;
            long rem = m - 2 * half; // 0 or 1

            // Option: build 'half', double it, insert the leftover
            long option1 = solve(half) + c + i * rem;
            best = Math.min(best, option1);

            // Option: build 'half+1', double it (overshoots), delete the excess
            if (half + 1 < m) { // guard against non-shrinking recursion at m=2
                long option2 = solve(half + 1) + c + d * (2 - rem);
                best = Math.min(best, option2);
            }
        }

        memo.put(m, best);
        return best;
    }
}
