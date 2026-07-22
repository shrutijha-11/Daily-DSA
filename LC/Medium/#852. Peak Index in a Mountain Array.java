class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if(n==1)
        return arr[0];
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
        int peak = inc[0];
        if(peak>=dec[n-1])
        return peak;
        return -1;
    }
}
