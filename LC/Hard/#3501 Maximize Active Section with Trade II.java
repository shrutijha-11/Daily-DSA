import java.util.*;

class Solution {

    // A maximal run of consecutive '0's.
    private static class Group {
        int start;
        int length;
        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    // Sparse table for O(1) range-max queries over an int array.
    private static class SparseTable {
        private final int[][] st; // st[i][j] = max(nums[j .. j + 2^i - 1])

        SparseTable(int[] nums) {
            int n = nums.length;
            int levels = bitLength(Math.max(n, 1)) + 1;
            st = new int[levels][n];
            if (n > 0) System.arraycopy(nums, 0, st[0], 0, n);
            for (int i = 1; i < levels; i++) {
                int half = 1 << (i - 1);
                for (int j = 0; j + (1 << i) <= n; j++) {
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + half]);
                }
            }
        }

        // Returns max(nums[l..r]) inclusive.
        int query(int l, int r) {
            int i = bitLength(r - l + 1) - 1;
            return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
        }

        private int bitLength(int n) {
            return Integer.SIZE - Integer.numberOfLeadingZeros(n);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        final int n = s.length();
        int onesCount = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') onesCount++;
        final int ones = onesCount;

        // Build zero groups and per-index group lookup.
        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }
            zeroGroupIndex[i] = zeroGroups.size() - 1; // -1 means s[i] == '1'
        }

        List<Integer> ans = new ArrayList<>();

        if (zeroGroups.isEmpty()) {
            // No zeros at all: no trade can ever help.
            for (int i = 0; i < queries.length; i++) ans.add(ones);
            return ans;
        }

        // zeroMergeLengths[i] = length of zeroGroups[i] + zeroGroups[i+1]
        int[] zeroMergeLengths = new int[Math.max(zeroGroups.size() - 1, 0)];
        for (int i = 0; i < zeroGroups.size() - 1; i++) {
            zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }

        SparseTable st = zeroMergeLengths.length > 0 ? new SparseTable(zeroMergeLengths) : null;

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            int left = zeroGroupIndex[l] == -1
                    ? -1
                    : (zeroGroups.get(zeroGroupIndex[l]).length - (l - zeroGroups.get(zeroGroupIndex[l]).start));
            int right = zeroGroupIndex[r] == -1
                    ? -1
                    : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);

            int startAdj = zeroGroupIndex[l] + 1;
            int endAdj = (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1) - 1;

            int activeSections = ones;

            if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                activeSections = Math.max(activeSections, ones + left + right);
            } else if (st != null && startAdj <= endAdj) {
                activeSections = Math.max(activeSections, ones + st.query(startAdj, endAdj));
            }

            int rBoundIndex = (s.charAt(r) == '1') ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1;

            if (s.charAt(l) == '0' && zeroGroupIndex[l] + 1 <= rBoundIndex) {
                activeSections = Math.max(activeSections,
                        ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }
            if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {
                activeSections = Math.max(activeSections,
                        ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(activeSections);
        }

        return ans;
    }

    // Quick manual test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "1000100";
        int[][] queries = {{1, 5}, {0, 6}, {0, 4}};
        System.out.println(sol.maxActiveSectionsAfterTrade(s, queries)); // expect [5, 7, 2]
    }
}
