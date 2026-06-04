class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int top=0,bot=m-1,l=0,r=n-1;
        while(top<=bot && l<=r)
        {
            for(int i=l;i<=r;++i)
            res.add(mat[top][i]);
            top++;
            for(int i=top;i<=bot;++i)
            res.add(mat[i][r]);
            r--;
            if(top<=bot)
            {
                for(int i=r;i>=l;--i)
                res.add(mat[bot][i]);
                bot--;
            }
            if(l<=r)
            {
                for(int i=bot;i>=top;--i)
                res.add(mat[i][l]);
                l++;
            }
        }
        return res;
    }
}

