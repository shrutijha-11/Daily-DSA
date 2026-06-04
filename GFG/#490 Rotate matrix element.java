// User function Template for Java

class Solution {
    int[][] rotateMatrix(int m, int n, int mat[][]) {
        // code here
    
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
    
        while (top < bottom && left < right) {

            int prev = mat[top + 1][left];

        // Top row
            for (int i = left; i <= right; i++) {
                int curr = mat[top][i];
                mat[top][i] = prev;
                prev = curr;
            }
            top++;
        // Right column
            for (int i = top; i <= bottom; i++) {
                int curr = mat[i][right];
                mat[i][right] = prev;
                prev = curr;
            }
            right--;
        // Bottom row
            for (int i = right; i >= left; i--) {
                int curr = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = curr;
            }
            bottom--;

        // Left column
            for (int i = bottom; i >= top; i--) {
                int curr = mat[i][left];
                mat[i][left] = prev;
                prev = curr;
            }
            left++;
        }
        return mat;
    }
}
