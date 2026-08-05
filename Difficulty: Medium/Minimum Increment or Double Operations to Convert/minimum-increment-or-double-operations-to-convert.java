class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int increments = 0;
        int max = 0;

        for (int x : arr) {
            increments += Integer.bitCount(x);
            max = Math.max(max, x);
        }

        int doubles = 0;
        while (max > 1) {
            doubles++;
            max >>= 1;
        }

        return increments + doubles;
    }
}