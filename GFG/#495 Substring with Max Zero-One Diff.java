class Solution {
    int maxSubstring(String s) {
        // code here
        int maxSoFar = Integer.MIN_VALUE;
        int currSum = 0;

        for (char ch : s.toCharArray()) {
            int val = (ch == '0') ? 1 : -1;

            currSum = Math.max(val, currSum + val);
            maxSoFar = Math.max(maxSoFar, currSum);
        }

        return (maxSoFar <= 0) ? -1 : maxSoFar;
    }
}
