class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] freq = new int[mx + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[mx + 1];

        // Count pairs divisible by g
        for (int g = mx; g >= 1; g--) {
            long cnt = 0;
            for (int m = g; m <= mx; m += g)
                cnt += freq[m];

            exact[g] = cnt * (cnt - 1) / 2;
        }

        // Inclusion-Exclusion
        for (int g = mx; g >= 1; g--) {
            for (int m = g + g; m <= mx; m += g)
                exact[g] -= exact[m];
        }

        // Prefix counts
        long[] prefix = new long[mx + 1];
        for (int g = 1; g <= mx; g++)
            prefix[g] = prefix[g - 1] + exact[g];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i];

            int lo = 1, hi = mx;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] > k)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[i] = lo;
        }

        return ans;
    }
}
