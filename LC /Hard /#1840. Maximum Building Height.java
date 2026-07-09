class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        // Add restriction for building 1 with height 0
        int[][] arr = new int[m + 1][2];
        arr[0][0] = 1;
        arr[0][1] = 0;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        m = arr.length;

        // Left to Right
        for (int i = 1; i < m; i++) {
            int dist = arr[i][0] - arr[i - 1][0];
            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + dist);
        }

        // Right to Left
        for (int i = m - 2; i >= 0; i--) {
            int dist = arr[i + 1][0] - arr[i][0];
            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + dist);
        }

        int ans = 0;

        // Find maximum possible height between consecutive restrictions
        for (int i = 1; i < m; i++) {
            int id1 = arr[i - 1][0];
            int h1 = arr[i - 1][1];
            int id2 = arr[i][0];
            int h2 = arr[i][1];

            int dist = id2 - id1;
            ans = Math.max(ans, (h1 + h2 + dist) / 2);
        }

        // Buildings after the last restriction
        int lastId = arr[m - 1][0];
        int lastHeight = arr[m - 1][1];
        ans = Math.max(ans, lastHeight + (n - lastId));

        return ans;
    }
}
