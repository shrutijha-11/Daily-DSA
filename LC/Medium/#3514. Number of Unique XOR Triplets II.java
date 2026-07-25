class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int maxVal = 1;
        for (int v : nums) maxVal = Math.max(maxVal, v);
        int bits = 32 - Integer.numberOfLeadingZeros(maxVal);
        int size = 1 << bits; // values/XORs all stay within [0, size)

        boolean[] present = new boolean[size];
        Set<Integer> distinctVals = new HashSet<>();
        for (int v : nums) {
            present[v] = true; // i=j=k, or i=j<k, or i<j=k all collapse to a single value
            distinctVals.add(v);
        }

        // All pairwise XORs from genuinely distinct indices i < j
        boolean[] pairXor = new boolean[size];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        // Combine each achievable pair-XOR with every distinct value to get real triplet values
        for (int p = 0; p < size; p++) {
            if (!pairXor[p]) continue;
            for (int v : distinctVals) {
                present[p ^ v] = true;
            }
        }

        int count = 0;
        for (boolean b : present) if (b) count++;
        return count;
    }
}
