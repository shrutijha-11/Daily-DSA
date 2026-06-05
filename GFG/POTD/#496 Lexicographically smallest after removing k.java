class Solution {
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    public String lexicographicallySmallest(String s, int k) {
        // code here
        int n = s.length();

        // Correct k
        if (isPowerOfTwo(n))
            k /= 2;
        else
            k *= 2;

        // Check validity
        if (k > n || n - k <= 0)
            return "-1";

        StringBuilder stack = new StringBuilder();
        int remove = k;

        for (char ch : s.toCharArray()) {
            while (stack.length() > 0 &&
                   remove > 0 &&
                   stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                remove--;
            }
            stack.append(ch);
        }

        // Remove remaining characters from the end
        while (remove > 0) {
            stack.deleteCharAt(stack.length() - 1);
            remove--;
        }
        return stack.length() == 0 ? "-1" : stack.toString();
    }
}
