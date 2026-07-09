class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store index of each element in b
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Convert a into indices of elements present in b
        for (int num : a) {
            if (map.containsKey(num)) {
                list.add(map.get(num));
            }
        }

        // Find LIS length
        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : list) {
            int idx = Collections.binarySearch(lis, x);

            if (idx < 0)
                idx = -(idx + 1);

            if (idx == lis.size())
                lis.add(x);
            else
                lis.set(idx, x);
        }

        int lcs = lis.size();

        // Deletions + Insertions
        return (a.length - lcs) + (b.length - lcs);
    }
}
