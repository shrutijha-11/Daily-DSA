class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // code here
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] next = dp.clone();

            // Subset containing only current element
            next[num % k] = true;

            // Extend previous subsets
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next[(r + num) % k] = true;
                }
            }

            dp = next;

            if (dp[0]) return true;
        }

        return false;
    }
}
