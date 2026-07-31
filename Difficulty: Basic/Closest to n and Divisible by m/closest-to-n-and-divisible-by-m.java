class Solution {
    static int closestNumber(int n, int m) {
        // code here
        int n1 = (n / m) * m;   // Java's / truncates toward zero, same as needed here
        int n2;
        if ((n * m) > 0) {
            n2 = n1 + m;
        } else {
            n2 = n1 - m;
        }

        int diff1 = Math.abs(n - n1);
        int diff2 = Math.abs(n - n2);

        if (diff1 < diff2) {
            return n1;
        } else if (diff2 < diff1) {
            return n2;
        } else {
            // tie -> return one with maximum absolute value
            return Math.max(Math.abs(n1), Math.abs(n2)) == Math.abs(n1) ? n1 : n2;
        }
    }
}