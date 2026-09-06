class Solution {
    private int[] arr;
    private int n;
    private int[][][] memo;

    public int minCount(int[] arr) {
        // code here
        this.arr = arr;
        this.n = arr.length;
        this.memo = new int[n + 1][n + 1][n + 1];
        for (int[][] plane : memo)
        {
            for (int[] row : plane)
                java.util.Arrays.fill(row, -1);
        }
        int maxUsed = solve(0, -1, -1);
        return n - maxUsed;
    }
    private int solve(int i, int incIdx, int decIdx) {
        if (i == n) return 0;
            int ii = incIdx + 1, di = decIdx + 1;
        if (memo[i][ii][di] != -1) return memo[i][ii][di];
            int best = solve(i + 1, incIdx, decIdx); // skip arr[i]
        if (incIdx == -1 || arr[incIdx] < arr[i]) {
            best = Math.max(best, 1 + solve(i + 1, i, decIdx)); // extend increasing
        }
        if (decIdx == -1 || arr[decIdx] > arr[i]) {
            best = Math.max(best, 1 + solve(i + 1, incIdx, i)); // extend decreasing
        }
        return memo[i][ii][di] = best;
    }
}