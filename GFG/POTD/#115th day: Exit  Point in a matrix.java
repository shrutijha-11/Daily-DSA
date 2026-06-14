class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        int i = 0, j = 0;
        int dir = 0; // 0=Right, 1=Down, 2=Left, 3=Up

        while (true) {
            dir = (dir + mat[i][j]) % 4;
            mat[i][j] = 0;

            if (dir == 0) {
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            } else {
                i--;
            }

            if (i < 0) {
                i++;
                break;
            }
            if (i >= n) {
                i--;
                break;
            }
            if (j < 0) {
                j++;
                break;
            }
            if (j >= m) {
                j--;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(i);
        ans.add(j);

        return ans;
    }
}
