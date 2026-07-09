class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        int[][] pref = new int[n + 1][m + 1];
        int[][] suff = new int[n + 1][m + 1];

        // Prefix LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    pref[i][j] = pref[i - 1][j - 1] + 1;
                else
                    pref[i][j] = Math.max(pref[i - 1][j], pref[i][j - 1]);
            }
        }

        // Suffix LCS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    suff[i][j] = suff[i + 1][j + 1] + 1;
                else
                    suff[i][j] = Math.max(suff[i + 1][j], suff[i][j + 1]);
            }
        }

        int lcs = pref[n][m];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            for (char c = 'a'; c <= 'z'; c++) {

                boolean ok = false;

                for (int j = 0; j < m; j++) {
                    if (s2.charAt(j) == c) {
                        if (pref[i][j] + suff[i][j + 1] == lcs) {
                            ok = true;
                            break;
                        }
                    }
                }

                if (ok) ans++;
            }
        }

        return ans;
    }
}
