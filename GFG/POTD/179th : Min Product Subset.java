class Solution {
    public int minProd(int[] arr) {
        // code here
        boolean hasZero = false;
        List<Integer> negs = new ArrayList<>();
        long posProduct = 1;

        for (int x : arr) {
            if (x == 0) {
                hasZero = true;
            } else if (x < 0) {
                negs.add(x);
            } else {
                posProduct *= x;
            }
        }

        int negCount = negs.size();

        if (negCount == 0) {
            // All non-negative
            if (hasZero) return 0;
            int minVal = Integer.MAX_VALUE;
            for (int x : arr) minVal = Math.min(minVal, x);
            return minVal;
        } else {
            // Sort negatives by absolute value ascending
            negs.sort((a, b) -> Math.abs(a) - Math.abs(b));

            long negProduct = 1;
            int startIdx = 0;
            if (negCount % 2 == 0) {
                // drop the negative with smallest absolute value
                startIdx = 1;
            }
            for (int i = startIdx; i < negCount; i++) {
                negProduct *= negs.get(i);
            }

            long result = negProduct * posProduct;
            return (int) result;
        }
    }
}
