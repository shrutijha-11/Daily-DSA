class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        
        StringBuilder half = new StringBuilder();
        char mid = '\0';
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                half.append((char) ('a' + i));
            }
            if (cnt[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
        }
        
        StringBuilder result = new StringBuilder(half);
        if (mid != '\0') result.append(mid);
        result.append(half.reverse());
        
        return result.toString();
    }
}
