class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0]=0;
        for(int i=1;i<n;i++)
        {
            int sum=0;
            int j=i-1;
            while(j>=0)
            {
                sum+=nums[j];
                j--;
            }
            left[i]=sum;
        }
        
        int[] right = new int[n];
        right[n-1]=0;
        for(int i=0;i<n-1;i++)
        {
            int sum=0;
            int j=i+1;
            while(j<n)
            {                
                sum+=nums[j];
                j++;
            }
            right[i]=sum;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++)
        res[i]=Math.abs(left[i]-right[i]);
        return res;
    }
}
