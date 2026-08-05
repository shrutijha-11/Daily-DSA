class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();
        for(int i=0;i<mat.length;i++)
        {
            ArrayList<Integer> r1 = new ArrayList<>();
            for(int j=0;j<mat[0].length;j++)
            {
                if(i==j)
                r1.add(mat[i][j]);
                else
                r1.add(mat[j][i]);
            }
            trans.add(r1);
        }
        return trans;
    }
}
