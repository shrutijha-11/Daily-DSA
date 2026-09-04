class Solution {
    public int maxDiffSum(int[] arr) {
        // code here
        int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        int keep = 0;    // Previous element is unchanged
        int change = 0;  // Previous element is changed to 1

        for (int i = 1; i < n; i++) {

            int newKeep = Math.max(
                keep + Math.abs(arr[i] - arr[i - 1]),
                change + Math.abs(arr[i] - 1)
            );

            int newChange = Math.max(
                keep + Math.abs(1 - arr[i - 1]),
                change
            );

            keep = newKeep;
            change = newChange;
        }

        return Math.max(keep, change);
    }
}