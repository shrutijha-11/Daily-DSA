class Solution {
    public String compress(String s) {
        // code here
        int n = s.length();

        // Build LPS (Longest Prefix Suffix) array
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }
        StringBuilder ans = new StringBuilder();

        int i = n - 1;

        while (i >= 0) {

            // len = length of prefix s[0...i]
        int len = i + 1;
        if (len % 2 == 0) {
            int half = len / 2;
            int period = len - lps[i];
            if (lps[i] >= half && len % (2 * period) == 0) {
                ans.append('*');
                i = half - 1;
                    continue;
                }
            }
            ans.append(s.charAt(i));
            i--;
        }
        return ans.reverse().toString();    
    }
}
