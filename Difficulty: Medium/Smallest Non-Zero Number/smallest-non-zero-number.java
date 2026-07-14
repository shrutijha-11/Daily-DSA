class Solution {
    public int find(int[] arr) {
        // code here
        long need = 0;

        // Process from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Ceiling of (need + arr[i]) / 2
            need = (need + arr[i] + 1) / 2;
        }

        return (int) need;
    }
}
