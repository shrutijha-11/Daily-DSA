class Solution {
    public int countWithout(int n, int d) {
        // code here
        if (n <= 0) return 0; // empty range, nothing to count

        String s = String.valueOf(n);
        int len = s.length();
        long count = 0;

        // 1) Count ALL numbers with fewer digits than n (lengths 1 .. len-1)
        int firstDigitChoices = 9 - (d == 0 ? 0 : 1); // digits 1-9, excluding d if d != 0
        long shorterCount = firstDigitChoices;
        for (int L = 1; L < len; L++) {
            count += shorterCount;
            shorterCount *= 9;
        }

        // 2) Count numbers with exactly len digits that are <= n
        for (int i = 0; i < len; i++) {
            int curDigit = s.charAt(i) - '0';

            for (int digit = (i == 0 ? 1 : 0); digit < curDigit; digit++) {
                if (digit == d) continue;
                count += pow9(len - i - 1);
            }

            if (curDigit == d) {
                return (int) count;
            }
        }

        count++; // n itself is valid

        return (int) count;
    }

    private long pow9(int places) {
        long result = 1;
        for (int i = 0; i < places; i++) {
            result *= 9;
        }
        return result;
    }
}
