class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;

        int[] up = new int[n];
        up[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                up[i] = up[i + 1];
            else
                up[i] = i;
        }

        int[] down = new int[n];
        down[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i])
                down[i] = down[i - 1];
            else
                down[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            ans.add(up[l] >= down[r]);
        }

        return ans;
    }
}
