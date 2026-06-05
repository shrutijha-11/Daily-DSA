class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        int n = mat.length;
        for(int i=0;i<n;i++)
        {
            int s=0,e=n-1;
            while(s<e)
            {
                int temp = mat[i][s];
                mat[i][s] = mat[i][e];
                mat[i][e] = temp;
                s++;e--;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
        }
    }
}
