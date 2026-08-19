class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        // code here
        int n = arr.length;
            if (n < 3) return 0;

            Arrays.sort(arr);

            return (int) (countTriplesLE(arr, n, r) - countTriplesLE(arr, n, (long) l - 1));
        }

        // Counts triplets (i < j < k) with arr[i] + arr[j] + arr[k] <= X
        // arr must already be sorted.
        private long countTriplesLE(int[] arr, int n, long X) {
            long count = 0;
            for (int i = 0; i < n - 2; i++) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    long sum = (long) arr[i] + arr[j] + arr[k];
                    if (sum <= X) {
                        // arr[i] + arr[j] with every element from j+1..k also satisfies <= X
                        count += (k - j);
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return count;
    }
}