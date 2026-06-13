class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int l = 0, r = n - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (arr[mid] == target) {
                    count++;
                    break;
                }

                if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return count;
    }
}
