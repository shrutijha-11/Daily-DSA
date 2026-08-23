class Solution {
    int transform(String s1, String s2) {
        // code here
        int n = s1.length();
        if (n != s2.length()) return -1;

        // Check if both strings have the same character frequencies
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }
        for (int f : freq) {
            if (f != 0) return -1;
        }

        // Two pointer approach from the end of both strings
        int i = n - 1;
        int j = n - 1;
        int matched = 0;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                matched++;
                j--;
            }
            i--;
        }

        return n - matched;
    }
}
