class Solution {
    public int count(int n, int m) {
        // code here
        // Adjacency list
        List<Integer>[] adj = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build adjacency
        for (int i = 1; i <= m; i++) {

            // Multiples of i
            for (int j = i; j <= m; j += i) {
                adj[i].add(j);
            }

            // Divisors of i
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    adj[i].add(j);
                    if (j != i / j) {
                        adj[i].add(i / j);
                    }
                }
            }

            // Remove duplicates
            Collections.sort(adj[i]);
            List<Integer> unique = new ArrayList<>();
            int prev = -1;
            for (int x : adj[i]) {
                if (x != prev) {
                    unique.add(x);
                    prev = x;
                }
            }
            adj[i] = unique;
        }

        long[] prev = new long[m + 1];
        Arrays.fill(prev, 1); // Arrays of length 1

        for (int len = 2; len <= n; len++) {
            long[] curr = new long[m + 1];

            for (int last = 1; last <= m; last++) {
                for (int next : adj[last]) {
                    curr[next] += prev[last];
                }
            }

            prev = curr;
        }

        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += prev[i];
        }

        return (int)ans;
    }
}
