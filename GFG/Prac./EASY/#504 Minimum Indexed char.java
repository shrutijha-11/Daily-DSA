class Solution {
    public static int minIndexChar(String s1, String s2) {
        // code here
        Set<Character> al1 = new LinkedHashSet<>();
        for(char x:s1.toCharArray())
        al1.add(x);
        Set<Character> al2 = new LinkedHashSet<>();
        for(char x:s2.toCharArray())
        al2.add(x);
        int c=0;
        for(char x:al1)
        {
            if(al2.contains(x))
            return c;
            c++;
        }
        return -1;
    }
}
