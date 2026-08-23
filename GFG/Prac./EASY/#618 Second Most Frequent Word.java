class Solution {
    public int secFrequent(String[] arr) {
        // code here
        HashMap<String,Integer> hm = new HashMap<>();
        for(String x:arr)
        hm.put(x,hm.getOrDefault(x,0)+1);
        List<Integer> lst = new ArrayList<>();
        for(Map.Entry<String,Integer> en : hm.entrySet())
        {
            int k = en.getValue();
            if(!lst.contains(k))
            lst.add(k);
        }
        Collections.sort(lst);
        if(lst.size()<2)
        return -1;
        return lst.get(lst.size()-2);
    }
}
