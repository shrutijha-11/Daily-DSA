class Solution {
    int search(int[] arr, int key) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int x:arr)
        al.add(x);
        /*Arrays.sort(arr);
        for(int x:arr)
        System.out.print(x+" ");
        int l=0;
        int h=arr.length-1;
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            if(arr[mid]==key)
            return mid;
            else if (arr[mid]<key)
            l=mid+1;
            else if (arr[mid]>key)
            h=mid-1;
        }*/
        if(al.contains(key))
        return al.indexOf(key);
        return -1;
    }
}
