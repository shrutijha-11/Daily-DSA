class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        int n = l.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int k : rank) {
            int lo = 0, hi = n - 1, ans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid + 1] >= k) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            long offset = k - prefix[ans];
            result.add((int) (l[ans] + offset - 1));
        }

        return result;
    }
}