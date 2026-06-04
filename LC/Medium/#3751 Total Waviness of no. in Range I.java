class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            char[] digits = String.valueOf(num).toCharArray();

            for (int i = 1; i < digits.length - 1; i++) {
                if ((digits[i] > digits[i - 1] && digits[i] > digits[i + 1]) ||
                    (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
