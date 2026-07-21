class Solution {
    public int minDeletions(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : arr) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) 
            idx = -(idx + 1);

            if (idx == lis.size())
                lis.add(x);
            else
                lis.set(idx, x);
        }

        return n - lis.size();
    }
}