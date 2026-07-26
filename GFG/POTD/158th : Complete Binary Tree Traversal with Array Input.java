class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int n = arr.length;
        int idx = 0;
        int levelSize = 1;
        
        while (idx < n) {
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelSize && idx < n; i++) {
                level.add(arr[idx++]);
            }
            
            Collections.sort(level);
            ans.add(level);
            
            levelSize *= 2;
        }
        
        return ans;
    }
}
