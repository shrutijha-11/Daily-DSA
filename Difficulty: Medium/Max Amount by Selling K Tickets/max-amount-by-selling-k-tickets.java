class Solution {
    static final int MOD = 1000000007;
    
    public int maxAmount(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            if (x > 0)
                pq.offer(x);
        }

        long ans = 0;

        while (k > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            ans = (ans + cur) % MOD;

            if (cur > 1)
                pq.offer(cur - 1);

            k--;
        }

        return (int) ans;
    }
}