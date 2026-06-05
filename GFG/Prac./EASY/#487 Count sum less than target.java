// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        int c=0;
        while(i<j)
        {
            int sum = arr[i]+arr[j];
            if(sum<target)
            {
                c+=j-i;
                i++;
            }
            else if(sum>=target)
            j--;
        }
        return c;
    }
}
