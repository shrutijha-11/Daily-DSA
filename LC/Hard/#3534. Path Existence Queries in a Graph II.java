class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] orderObj = new Integer[n];
        for (int i = 0; i < n; i++) orderObj[i] = i;
        Arrays.sort(orderObj, (x, y) -> nums[x] - nums[y]);
        int[] order = new int[n];
        for (int i = 0; i < n; i++) order[i] = orderObj[i];

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nums[order[i]];

        int[] pos = new int[n];
        for (int idx = 0; idx < n; idx++) pos[order[idx]] = idx;

        int[] hi = new int[n];
        int r = 0;
        for (int p = 0; p < n; p++) {
            if (r < p) r = p;
            while (r + 1 < n && a[r + 1] - a[p] <= maxDiff) r++;
            hi[p] = r;
        }

        int[] lo = new int[n];
        int l = 0;
        for (int p = 0; p < n; p++) {
            while (a[p] - a[l] > maxDiff) l++;
            lo[p] = l;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;

        int[][] up = new int[LOG + 1][n];
        int[][] down = new int[LOG + 1][n];
        up[0] = hi;
        down[0] = lo;
        for (int t = 1; t <= LOG; t++) {
            for (int p = 0; p < n; p++) {
                up[t][p] = up[t - 1][up[t - 1][p]];
                down[t][p] = down[t - 1][down[t - 1][p]];
            }
        }

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int u = queries[qi][0], v = queries[qi][1];
            if (u == v) {
                ans[qi] = 0;
                continue;
            }
            int i = pos[u], j = pos[v];
            if (i < j) {
                ans[qi] = minUp(up, LOG, i, j);
            } else {
                ans[qi] = minDown(down, LOG, i, j);
            }
        }
        return ans;
    }

    private int minUp(int[][] up, int LOG, int start, int target) {
        if (up[LOG][start] < target) return -1;
        int cur = start, dist = 0;
        for (int t = LOG; t >= 0; t--) {
            int nxt = up[t][cur];
            if (nxt < target) {
                cur = nxt;
                dist += (1 << t);
            }
        }
        return dist + 1;
    }

    private int minDown(int[][] down, int LOG, int start, int target) {
        if (down[LOG][start] > target) return -1;
        int cur = start, dist = 0;
        for (int t = LOG; t >= 0; t--) {
            int nxt = down[t][cur];
            if (nxt > target) {
                cur = nxt;
                dist += (1 << t);
            }
        }
        return dist + 1;
    }
}
