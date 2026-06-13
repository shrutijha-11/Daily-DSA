class Solution {
    public String frequencySort(String s) {
        // code here
        if(s.length()==1)
        return s;
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for(char x : s.toCharArray())
        tm.put(x,tm.getOrDefault(x,0)+1);
        ArrayList<Integer> al = new ArrayList<>();
        for(Map.Entry<Character,Integer> en : tm.entrySet())
        al.add(en.getValue());
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<al.size())
        {
            for(Map.Entry<Character,Integer> en : tm.entrySet())
            {
                if(en.getValue()==al.get(i))
                {
                    for(int j=1;j<=al.get(i);j++)
                    {
                        sb.append(en.getKey());
                        stk.push(en.getKey());
                    }
                }
            }
            while(!stk.isEmpty())
            tm.remove(stk.pop());
            i++;
        }
        return sb.toString();
    }
};
