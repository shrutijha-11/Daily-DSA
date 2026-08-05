class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        // code here
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return sortCount(prefix, 0, n + 1, l, r);
    }
    
    private int sortCount(long[] prefix, int lo, int hi, int l, int r) {
        if (hi - lo <= 1) return 0;
        
        int mid = (lo + hi) / 2;
        int count = sortCount(prefix, lo, mid, l, r) + sortCount(prefix, mid, hi, l, r);
        
        int j = mid, k = mid;
        for (int i = lo; i < mid; i++) {
            while (j < hi && prefix[j] - prefix[i] < l) j++;
            while (k < hi && prefix[k] - prefix[i] <= r) k++;
            count += (k - j);
        }
        
        // merge step to keep prefix[lo..hi) sorted
        long[] merged = new long[hi - lo];
        int p1 = lo, p2 = mid, idx = 0;
        while (p1 < mid && p2 < hi) {
            if (prefix[p1] <= prefix[p2]) merged[idx++] = prefix[p1++];
            else merged[idx++] = prefix[p2++];
        }
        while (p1 < mid) merged[idx++] = prefix[p1++];
        while (p2 < hi) merged[idx++] = prefix[p2++];
        
        System.arraycopy(merged, 0, prefix, lo, merged.length);
        
        return count;
    }
}