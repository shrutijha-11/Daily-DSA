class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        char mid = 0;
        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) mid = (char) ('a' + i);
            half[i] = cnt[i] / 2;
        }
        int L = n / 2;

        long total = multinomial(half, L, k + 1);
        if (total < k) return "";

        int[] work = half.clone();
        int remainingLen = L;
        StringBuilder chosen = new StringBuilder();

        for (int pos = 0; pos < L; pos++) {
            boolean placed = false;
            for (int i = 0; i < 26; i++) {
                if (work[i] == 0) continue;
                work[i]--;
                remainingLen--;
                long cntX = multinomial(work, remainingLen, k + 1);
                if (k <= cntX) {
                    chosen.append((char) ('a' + i));
                    placed = true;
                    break;
                } else {
                    k -= cntX;
                    work[i]++;
                    remainingLen++;
                }
            }
            if (!placed) return ""; // shouldn't happen given the total check
        }

        String firstHalf = chosen.toString();
        StringBuilder result = new StringBuilder();
        result.append(firstHalf);
        if (mid != 0) result.append(mid);
        result.append(new StringBuilder(firstHalf).reverse());
        return result.toString();
    }

    // C(a, b) capped at 'cap'
    private long C(int a, int b, long cap) {
        if (b < 0 || b > a) return 0;
        b = Math.min(b, a - b);
        if (b == 0) return 1;
        long result = 1;
        for (int i = 1; i <= b; i++) {
            result = result * (a - b + i) / i;
            if (result >= cap) return cap;
        }
        return result;
    }

    // multinomial coefficient of 'counts' over total 'length', capped at 'cap'
    private long multinomial(int[] counts, int length, long cap) {
        long result = 1;
        int remaining = length;
        for (int i = 0; i < 26; i++) {
            int v = counts[i];
            if (v == 0) continue;
            long cval = C(remaining, v, cap);
            result *= cval;
            if (result >= cap) return cap;
            remaining -= v;
        }
        return result;
    }
}
