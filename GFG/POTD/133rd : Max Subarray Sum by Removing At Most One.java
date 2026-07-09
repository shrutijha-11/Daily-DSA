class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        long noSkip = arr[0];
        long oneSkip = Long.MIN_VALUE / 2;
        long ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long prev = noSkip;

            noSkip = Math.max(arr[i], prev + arr[i]);
            oneSkip = Math.max(prev, oneSkip + arr[i]);

            ans = Math.max(ans, Math.max(noSkip, oneSkip));
        }

        return (int) ans;
    }
}
