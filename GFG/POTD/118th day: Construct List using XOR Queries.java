class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        
        int xr = 0;
        
        // Initial array contains 0
        arr.add(0);

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 0) {
                arr.add(x ^ xr);
            } else {
                xr ^= x;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int val : arr) {
            ans.add(val ^ xr);
        }

        Collections.sort(ans);
        return ans;
    }
}
