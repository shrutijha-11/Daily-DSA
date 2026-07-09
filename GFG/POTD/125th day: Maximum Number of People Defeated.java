class Solution {
    public int maxPeople(long p) {
        long low = 0, high = 2000000;
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) * (2 * mid + 1) / 6;

            if (sum <= p) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
