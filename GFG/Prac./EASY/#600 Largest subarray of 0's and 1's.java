class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int res=0;
        for(int i=0;i<arr.length;i++)
        {
            sum += (arr[i]==0)?-1:1;
            if(sum==0)
            res=i+1;
            if(mp.containsKey(sum))
            res = Math.max(res,i-mp.get(sum));
            else
            mp.put(sum,i);
        }
        return res;
    }
}
