class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        int n = arr.length;
        long[] paper = new long[n + 1];
        paper[0] = s;
        long sum = s;
        
        // Simulate the process, building the paper array
        for (int i = 0; i < n; i++) {
            long written = sum + arr[i];   // what child i writes
            paper[i + 1] = written;
            sum += written;                // update total sum on paper
        }
        
        // Sort descending
        Long[] boxed = new Long[n + 1];
        for (int i = 0; i <= n; i++) boxed[i] = paper[i];
        Arrays.sort(boxed, Collections.reverseOrder());
        
        // Greedy subset-sum check (valid since sequence is super-increasing)
        long remaining = x;
        for (long v : boxed) {
            if (v <= remaining) {
                remaining -= v;
            }
        }
        
        return remaining == 0;
    }
}