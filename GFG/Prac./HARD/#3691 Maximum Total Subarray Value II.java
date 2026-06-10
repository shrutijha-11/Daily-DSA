import java.util.*;

class Solution {
    class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] stMax, stMin;
    int[] log;

    private int getMax(int l, int r) {
        int k = log[r - l + 1];
        return Math.max(stMax[k][l], stMax[k][r - (1 << k) + 1]);
    }

    private int getMin(int l, int r) {
        int k = log[r - l + 1];
        return Math.min(stMin[k][l], stMin[k][r - (1 << k) + 1]);
    }

    private long value(int l, int r) {
        return (long)getMax(l, r) - getMin(l, r);
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int P = log[n] + 1;
        stMax = new int[P][n];
        stMin = new int[P][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int p = 1; p < P; p++) {
            for (int i = 0; i + (1 << p) <= n; i++) {
                stMax[p][i] = Math.max(
                    stMax[p - 1][i],
                    stMax[p - 1][i + (1 << (p - 1))]
                );

                stMin[p][i] = Math.min(
                    stMin[p - 1][i],
                    stMin[p - 1][i + (1 << (p - 1))]
                );
            }
        }

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(value(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(value(cur.l, nr), cur.l, nr));
            }
        }

        return ans;
    }
}
