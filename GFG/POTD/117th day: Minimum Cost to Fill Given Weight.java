class Solution {
    public int minimumCost(int[] cost, int w) {
        int INF = (int)1e9;
        int[] dp = new int[w + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int wt = 1; wt <= cost.length; wt++) {
            if (cost[wt - 1] == -1) continue;

            for (int i = wt; i <= w; i++) {
                dp[i] = Math.min(dp[i],
                                 dp[i - wt] + cost[wt - 1]);
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}
