class Solution {
    public int findIndex(String s) {
        // code here
        int n = s.length();

        int closesRight = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') closesRight++;
        }

        int opensLeft = 0;

        for (int k = 0; k <= n; k++) {
            if (opensLeft == closesRight) {
                return k;
            }

            if (k < n) {
                if (s.charAt(k) == '(') {
                    opensLeft++;
                } else {
                    closesRight--;
                }
            }
        }

        return -1;
    }
}
