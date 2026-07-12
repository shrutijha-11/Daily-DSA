class Solution {
    static final long MOD = 1000000007L;

    int minOperations(int[] b) {
        // code here
        int n = b.length;
        boolean[] vis = new boolean[n];

        ArrayList<Integer> cycles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int cur = i;
                int len = 0;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1;   // convert to 0-based
                    len++;
                }

                cycles.add(len);
            }
        }

        HashMap<Integer, Integer> maxPower = new HashMap<>();

        for (int len : cycles) {
            int x = len;

            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {
                    int cnt = 0;
                    while (x % p == 0) {
                        x /= p;
                        cnt++;
                    }
                    maxPower.put(p, Math.max(maxPower.getOrDefault(p, 0), cnt));
                }
            }

            if (x > 1) {
                maxPower.put(x, Math.max(maxPower.getOrDefault(x, 0), 1));
            }
        }

        long ans = 1;

        for (Map.Entry<Integer, Integer> e : maxPower.entrySet()) {
            int prime = e.getKey();
            int exp = e.getValue();

            long val = 1;
            long base = prime;

            while (exp > 0) {
                if ((exp & 1) == 1)
                    val = (val * base) % MOD;
                base = (base * base) % MOD;
                exp >>= 1;
            }

            ans = (ans * val) % MOD;
        }

        return (int) ans;
    }
};