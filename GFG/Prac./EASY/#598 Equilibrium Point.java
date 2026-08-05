class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int[] suff = new int[n];
        suff[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
        suff[i] = arr[i]+suff[i+1];
        int[] preff  = new int[n];
        preff[0] = arr[0];
        for(int i=1;i<n;i++)
        preff[i] = arr[i]+preff[i-1];
        for(int i=0;i<n;i++)
        {
            if(preff[i]==suff[i])
            return i;
        }
        return -1;
    }
}
