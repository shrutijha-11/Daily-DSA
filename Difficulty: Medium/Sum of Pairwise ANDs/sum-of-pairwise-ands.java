class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        long totalSum = 0;
        int n = arr.length;
       // Check each bit position (assuming 32-bit integers)
       for (int bit = 0; bit < 32; bit++) {
           int cnt = 0;
           for (int i = 0; i < n; i++) {
               if ((arr[i] & (1 << bit)) != 0) {
                   cnt++;
               }
           }
           // Number of pairs where both elements have this bit set
           long pairs = (long) cnt * (cnt - 1) / 2;
           totalSum += pairs * (1L << bit);
       }
       return totalSum;
    }
}