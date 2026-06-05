// User function Template for Java

class Solution {
    String removeDuplicates(String s) {
        LinkedHashSet<Character> hs = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++)
        hs.add(s.charAt(i));
        StringBuilder sb = new StringBuilder();
        for(char x:hs)
        sb.append(x);
        return sb.toString();
    }
}

