class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new TreeMap<>();
        for(char x:s.toCharArray())
        map.put(x,map.getOrDefault(x,0)+1);
        ArrayList<Integer> al = new ArrayList<>();
        for(Map.Entry<Character,Integer> en : map.entrySet())
        al.add(en.getValue());
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for(int i=al.size()-1;i>=0;i--)
        {
            int x = al.get(i);
            for(Map.Entry<Character,Integer> en : map.entrySet())
            {
                if(en.getValue()==x)
                {
                    for(int j=1;j<=x;j++)
                    sb.append(en.getKey());
                    stk.push(en.getKey());
                }
            }
            while(!stk.isEmpty())
            map.remove(stk.pop());
        }
        return sb.toString();
    }
}
