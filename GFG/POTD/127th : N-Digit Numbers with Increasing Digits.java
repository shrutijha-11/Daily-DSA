class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            ans.add(0);
        }
        
        dfs(1, n, 0, ans);
        return ans;
    }
    
    private static void dfs(int digit, int n, int num, ArrayList<Integer> ans) {
        if (n == 0) {
            ans.add(num);
            return;
        }
        
        for (int i = digit; i <= 9; i++) {
            dfs(i + 1, n - 1, num * 10 + i, ans);
        }
    }
}
