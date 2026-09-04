class Solution {
    public int solve(int n, String s) {
        // code here
        int available = n;
        int rejected = 0;

        // 0 = not seen
        // 1 = using a computer
        // 2 = rejected
        int[] state = new int[26];

        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';

            if (state[idx] == 0) {
                // Customer arrives
                if (available > 0) {
                    available--;
                    state[idx] = 1;
                } else {
                    rejected++;
                    state[idx] = 2;
                }
            } 
            else if (state[idx] == 1) {
                // Customer leaves
                available++;
                state[idx] = 0;
            }
            // If state == 2, this is the departure of a rejected customer.
            // It never occupied a computer, so do nothing.
        }

        return rejected;
    }
}
