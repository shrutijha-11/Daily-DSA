class Solution {
    public int numOfWays(int n, int m) {
        long cells = 1L * n * m;

        long total = cells * (cells - 1);

        long attacking = 4L * (
                1L * (n - 1) * (m - 2)
              + 1L * (n - 2) * (m - 1)
        );

        return (int)(total - attacking);
    }
}
