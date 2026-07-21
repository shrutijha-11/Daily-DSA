class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int n = s.length();

        int[] best = new int[26];
        Arrays.fill(best, -1);

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            int reach;
            if (c == 25) {
                reach = i;
            } else if (best[c + 1] != -1) {
                reach = best[c + 1];
            } else {
                reach = i;
            }

            best[c] = Math.max(best[c], reach);

            if (c == 0) {
                ans = Math.max(ans, reach - i);
            }
        }

        return ans;
    }
}
