
class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        if(b.length>a.length)
        return false;
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        int c=0;
        while(j<b.length && i<a.length)
        {
            if(a[i]==b[j])
            {
                i++;j++;
                c++;
            }
            else if(a[i]>b[j])
            return false;
            else
            i++;
        }
        if(c==b.length)
        return true;
        return false;
    }
}

