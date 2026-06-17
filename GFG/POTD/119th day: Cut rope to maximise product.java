class Solution {
    public long maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        long ans;

        if (n % 3 == 0) {
            ans = (long) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            ans = 4L * (long) Math.pow(3, (n - 4) / 3);
        } else {
            ans = 2L * (long) Math.pow(3, (n - 2) / 3);
        }

        return ans;
    }
}
