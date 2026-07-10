class Solution {
    public int getCount(int n) {
        // code here
        while (n % 2 == 0)
        n /= 2;

        int divisors = 1;

        for (int p = 3; p * p <= n; p += 2) {
            int cnt = 0;
            while (n % p == 0) {
                cnt++;
                n /= p;
            }
            divisors *= (cnt + 1);
        }

        if (n > 1) divisors *= 2;

        return divisors - 1;
    }
}
