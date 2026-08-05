class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int N = n;
        int K = k;

        // maxEndingHere[i] = maximum subarray sum ending at i
        int[] maxEndingHere = new int[N];
        maxEndingHere[0] = arr[0];

        for (int i = 1; i < N; i++) {
            maxEndingHere[i] = Math.max(arr[i], maxEndingHere[i - 1] + arr[i]);
        }

        // Sum of first window of size K
        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        // Slide the window
        for (int i = K; i < N; i++) {
            windowSum += arr[i] - arr[i - K];

            // Window alone
            ans = Math.max(ans, windowSum);

            // Extend with best subarray ending before the window
            ans = Math.max(ans, windowSum + maxEndingHere[i - K]);
        }

        return ans;
    }
}
