class Solution {
    public int countFriendsPairings(int n) {
        // code here
        if (n <= 2) return n;

        int prev2 = 1; // f(1)
        int prev1 = 2; // f(2)

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + (i - 1) * prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}