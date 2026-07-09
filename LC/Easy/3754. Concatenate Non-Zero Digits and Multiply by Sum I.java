class Solution {
    public long sumAndMultiply(int n) {
        long num =0,sum=0;
        long i=1;
        while(n>0)
        {
            long d = n%10;
            if(d!=0)
            {
                num = d*i+num;
                sum+=d;
                i*=10;
            }
            n/=10;
        }
        return num*sum;
    }
}
