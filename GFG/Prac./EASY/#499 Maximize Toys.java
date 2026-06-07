// User function Template for Java

class Solution {
    static int toyCount(int N, int K, int arr[]) {
        // code here
        int res=0;
        Arrays.sort(arr);
        for(int x:arr)
        {
            if(x<=K && K-x>=0)
            {
                res++;
                K=K-x;
            }
            else
            break;
        }
        return res;
    }
}
