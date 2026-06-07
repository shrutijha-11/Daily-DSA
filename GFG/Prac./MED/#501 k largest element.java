class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<=k;i++)
        res.add(arr[n-i]);
        return res;
    }
}
