class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n];
        inc[n-1]=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            inc[i]=inc[i+1];
            else
            inc[i]=i;
        }
        int[] dec = new int[n];
        dec[0]=0;
        for(int i=1;i<n;i++)
        {
            if(arr[i]<arr[i-1])
            dec[i]=dec[i-1];
            else
            dec[i]=i;
        }
        int p = inc[0];
        if(p==0 || p==n-1)
        return false;
        int q = dec[n-1];
        if(q==0 || q==n-1)
        return false;
        if(inc[0]>=dec[n-1])
        return true;
        return false;
    }
}
