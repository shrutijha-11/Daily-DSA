import java.util.stream.*;
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Arrays.sort(arr);
        ArrayList<Integer> al = new ArrayList<>();
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        for(int x:arr)
        hm.put(x,hm.getOrDefault(x,0)+1);
        Map<Integer, Integer> srt = hm.entrySet().stream()
        .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1, e2) -> e1,LinkedHashMap::new));
        for(Map.Entry<Integer,Integer> en : srt.entrySet())
        {
            for(int i=1;i<=en.getValue();i++)
            al.add(en.getKey());
        }
        return al;
    }
}