class Solution {
    public ArrayList<Integer> getDivisors(int n) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n%i==0 && !al.contains(i))
            {
                al.add(i);
                if(!al.contains(n/i))
                al.add(n/i);
            }
        }
        Collections.sort(al);
        return al;
    }
}
