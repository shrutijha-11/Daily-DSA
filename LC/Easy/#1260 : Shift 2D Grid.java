class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            List<Integer> mkc = new ArrayList<>();
            for(int j=0;j<n;j++)
            mkc.add(grid[i][j]);
            res.add(mkc); 
        }
        for(int c=1;c<=k;c++)
        {
            int el = res.get(m-1).get(n-1);
            for(int i=m-1;i>0;i--)
            {
                for(int j=n-1;j>0;j--)
                {
                    res.get(i).set(j,res.get(i).get(j-1));
                }
                res.get(i).set(0,res.get(i-1).get(n-1));
            }
            for(int j=n-1;j>0;j--)
            res.get(0).set(j,res.get(0).get(j-1));
            res.get(0).set(0,el);
        }
        return res;
    }
}
