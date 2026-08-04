class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);

        int n = arr.length;
        int i = 0;
        int ans = 0;

        for (int j = 0; j < n; j++) {
            while (arr[j] - arr[i] >= k) {
                i++;
            }
            ans += (j - i);
        }

        return ans;
    }
}
