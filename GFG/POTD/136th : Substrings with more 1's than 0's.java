class Solution {
    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countSubstring(String s) {
        int n = s.length();

        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (s.charAt(i - 1) == '1' ? 1 : -1);
        }

        int offset = n + 1;
        BIT bit = new BIT(2 * n + 3);

        long ans = 0;

        bit.update(prefix[0] + offset, 1);

        for (int i = 1; i <= n; i++) {
            ans += bit.query(prefix[i] + offset - 1);
            bit.update(prefix[i] + offset, 1);
        }

        return (int)ans;
    }
}
