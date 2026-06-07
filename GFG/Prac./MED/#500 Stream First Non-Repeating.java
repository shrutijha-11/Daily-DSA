class Solution {
    public String firstNonRepeating(String s) {
        // code here
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char x:s.toCharArray())
        {
            freq[x-97]++;
            if(freq[x-97]==1)
            q.add(x);
            while(!q.isEmpty() && freq[q.peek()-97]>1)
            q.remove();
            if(q.isEmpty())
            sb.append('#');
            else
            sb.append(q.peek());
        }
        return sb.toString();
    }
}
