class Solution {
    public int findMax(int n) {
        // code here
        String s = Integer.toString(n);
        int len = s.length();
        char[] digits = s.toCharArray();
        int best = n;
        int bestSum = digitSum(s);
        for (int i = len - 1; i >= 0; i--) 
        {
            if (digits[i] == '0') continue; // can't decrease a 0
            char[] cand = digits.clone();
            cand[i]--;                              // step down this digit
            for (int j = i + 1; j < len; j++) 
            cand[j] = '9'; // max out the rest
            // strip leading zeros (but keep at least 1 digit)
            int start = 0;
            while (start < len - 1 && cand[start] == '0')
            start++;
            String candStr = new String(cand, start, len - start);
            int candVal = Integer.parseInt(candStr);
            int candSum = digitSum(candStr);
            // prefer higher digit sum; on tie, prefer the larger number
            if (candSum > bestSum || (candSum == bestSum && candVal > best)) {
                bestSum = candSum;
                best = candVal;
            }
        }
        return best;
    }
    private int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) sum += c - '0';
        return sum;
    }
}
